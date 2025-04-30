package my.algorithm;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import java.util.*;
import java.util.concurrent.*;

public class TieredMatchmaker {
    private final JedisPool jedisPool;
    private final ScheduledExecutorService scheduler;
    
    // 配置参数
    private final int tierSize = 200; // 每个MMR分层的大小
    private final int baseMatchRange = 50; // 基础匹配范围
    private final int maxWaitTimeSec = 300; // 最大等待时间(秒)
    private final int expandRate = 10; // 每分钟扩展的范围值
    
    public TieredMatchmaker(String redisHost) {
        this.jedisPool = new JedisPool(redisHost);
        this.scheduler = Executors.newScheduledThreadPool(2);
        startBackgroundTasks();
    }
    
    private void startBackgroundTasks() {
        // 每10秒运行一次匹配尝试
        scheduler.scheduleAtFixedRate(this::matchProcess, 1, 10, TimeUnit.SECONDS);
        
        // 每分钟检查长时间等待玩家
        scheduler.scheduleAtFixedRate(this::checkLongWaitPlayers, 5, 60, TimeUnit.SECONDS);
    }

    // 在TieredMatchmaker类中添加以下方法

    // 玩家加入队列
    public void addPlayer(String playerId, int mmr) {
        try (Jedis jedis = jedisPool.getResource()) {
            // 计算分层key
            int tier = mmr / tierSize;
            String tierKey = "match:tier:" + tier;

            // 存储玩家信息(包括进入时间)
            long now = System.currentTimeMillis();
            Map<String, String> playerData = new HashMap<>();
            playerData.put("mmr", String.valueOf(mmr));
            playerData.put("joinTime", String.valueOf(now));
            jedis.hset("player:data:" + playerId, playerData);

            // 加入分层ZSET (使用MMR作为score)
            jedis.zadd(tierKey, mmr, playerId);

            // 加入全局等待队列(按时间排序)
            jedis.zadd("match:waiting_queue", now, playerId);

            System.out.println("Added player " + playerId + " to tier " + tier);
        }
    }

    // 从队列移除玩家
    private void removePlayer(Jedis jedis, String playerId) {
        // 获取玩家数据
        Map<String, String> data = jedis.hgetAll("player:data:" + playerId);
        if (data.isEmpty()) return;

        int mmr = Integer.parseInt(data.get("mmr"));
        int tier = mmr / tierSize;

        // 从分层中移除
        jedis.zrem("match:tier:" + tier, playerId);

        // 从等待队列移除
        jedis.zrem("match:waiting_queue", playerId);

        // 清除玩家数据
        jedis.del("player:data:" + playerId);
    }

    // 在TieredMatchmaker类中添加

    private void matchProcess() {
        try (Jedis jedis = jedisPool.getResource()) {
            // 获取等待时间最长的玩家
            Set<String> waitingPlayers = jedis.zrange("match:waiting_queue", 0, 49); // 每次处理前50名

            for (String playerId : waitingPlayers) {
                // 获取玩家数据
                Map<String, String> playerData = jedis.hgetAll("player:data:" + playerId);
                if (playerData.isEmpty()) continue;

                int mmr = Integer.parseInt(playerData.get("mmr"));
                long joinTime = Long.parseLong(playerData.get("joinTime"));

                // 计算动态范围
                int dynamicRange = calculateDynamicRange(joinTime);

                // 尝试在当前分层匹配
                List<String> matchedPair = tryMatchInTier(jedis, playerId, mmr, mmr - dynamicRange, mmr + dynamicRange);

                // 当前分层未匹配成功，尝试相邻分层
                if (matchedPair == null) {
                    int currentTier = mmr / tierSize;
                    matchedPair = tryMatchInAdjacentTiers(jedis, playerId, mmr, dynamicRange, currentTier);
                }

                // 处理匹配结果
                if (matchedPair != null) {
                    System.out.println("Matched: " + matchedPair.get(0) + " with " + matchedPair.get(1));
                    // 从所有队列中移除已匹配玩家
                    matchedPair.forEach(p -> removePlayer(jedis, p));
                    // 这里应该通知游戏服务器匹配结果
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 计算动态匹配范围
    private int calculateDynamicRange(long joinTime) {
        long waitTimeSec = (System.currentTimeMillis() - joinTime) / 1000;
        double timeFactor = Math.min(waitTimeSec / 60.0, 5); // 最大扩展5倍
        return baseMatchRange + (int)(expandRate * timeFactor);
    }

    // 在指定分层尝试匹配
    private List<String> tryMatchInTier(Jedis jedis, String playerId, int mmr, int minRange, int maxRange) {
        int tier = mmr / tierSize;
        String tierKey = "match:tier:" + tier;

        // 查找范围内的玩家(排除自己)
        Set<String> candidates = jedis.zrangeByScore(tierKey, minRange, maxRange);
        candidates.remove(playerId);

        if (!candidates.isEmpty()) {
            // 选择最接近的玩家
            String bestMatch = findBestMatch(jedis, mmr, candidates);
            return Arrays.asList(playerId, bestMatch);
        }
        return null;
    }

    // 尝试在相邻分层匹配
    private List<String> tryMatchInAdjacentTiers(Jedis jedis, String playerId, int mmr, int range, int baseTier) {
        // 先尝试更高分层，再尝试更低分层
        for (int tierOffset : new int[]{1, -1}) {
            int targetTier = baseTier + tierOffset;
            if (targetTier < 0) continue; // 避免负分层

            String tierKey = "match:tier:" + targetTier;
            Set<String> candidates = jedis.zrangeByScore(tierKey, mmr - range, mmr + range);

            if (!candidates.isEmpty()) {
                String bestMatch = findBestMatch(jedis, mmr, candidates);
                return Arrays.asList(playerId, bestMatch);
            }
        }
        return null;
    }

    // 寻找MMR最接近的对手
    private String findBestMatch(Jedis jedis, int mmr, Set<String> candidateIds) {
        String bestMatch = null;
        int smallestDiff = Integer.MAX_VALUE;

        for (String candidateId : candidateIds) {
            Map<String, String> data = jedis.hgetAll("player:data:" + candidateId);
            if (data.isEmpty()) continue;

            int candidateMmr = Integer.parseInt(data.get("mmr"));
            int diff = Math.abs(mmr - candidateMmr);

            if (diff < smallestDiff) {
                smallestDiff = diff;
                bestMatch = candidateId;
            }
        }

        return bestMatch;
    }

    // 在TieredMatchmaker类中添加

    private void checkLongWaitPlayers() {
        try (Jedis jedis = jedisPool.getResource()) {
            // 找出等待超过最大时间的玩家
            long cutoff = System.currentTimeMillis() - maxWaitTimeSec * 1000;
            Set<String> longWaiters = jedis.zrangeByScore("match:waiting_queue", 0, cutoff);

            if (!longWaiters.isEmpty()) {
                System.out.println("Found " + longWaiters.size() + " long-waiting players");

                for (String playerId : longWaiters) {
                    // 强制扩大匹配范围
                    Map<String, String> data = jedis.hgetAll("player:data:" + playerId);
                    if (data.isEmpty()) continue;

                    int mmr = Integer.parseInt(data.get("mmr"));
                    int forcedRange = baseMatchRange * 3; // 3倍基础范围

                    // 全部分层搜索
                    List<String> matchedPair = tryMatchInAllTiers(jedis, playerId, mmr, forcedRange);

                    if (matchedPair != null) {
                        System.out.println("Force matched long-waiter: " + playerId);
                        matchedPair.forEach(p -> removePlayer(jedis, p));
                    }
                }
            }
        }
    }

    // 在所有分层中搜索匹配
    private List<String> tryMatchInAllTiers(Jedis jedis, String playerId, int mmr, int range) {
        // 获取所有存在的分层
        Set<String> tierKeys = jedis.keys("match:tier:*");

        for (String tierKey : tierKeys) {
            Set<String> candidates = jedis.zrangeByScore(tierKey, mmr - range, mmr + range);
            candidates.remove(playerId);

            if (!candidates.isEmpty()) {
                String bestMatch = findBestMatch(jedis, mmr, candidates);
                return Arrays.asList(playerId, bestMatch);
            }
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        TieredMatchmaker matchmaker = new TieredMatchmaker("localhost");

        // 模拟玩家加入
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            int mmr = 1000 + rand.nextInt(2000); // MMR在1000-3000之间
            matchmaker.addPlayer("player_" + i, mmr);
            Thread.sleep(rand.nextInt(500)); // 随机间隔加入
        }

        // 保持运行
        Thread.sleep(60000);
    }
}
