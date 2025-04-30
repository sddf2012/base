package my.algorithm;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class RealtimeMatchmaker {
    // 玩家类
    static class Player {
        String id;
        int mmr;
        long queueTime;
        boolean isMatched = false;
        
        public Player(String id, int mmr) {
            this.id = id;
            this.mmr = mmr;
            this.queueTime = System.currentTimeMillis();
        }
    }
    
    // 匹配队列 (线程安全)
    private final Queue<Player> matchQueue = new ConcurrentLinkedQueue<>();
    private final Lock queueLock = new ReentrantLock();
    private final Condition matchCondition = queueLock.newCondition();
    
    // 配置参数
    private int baseMatchRange = 100;
    private int maxWaitTime = 30; // 秒
    private int matchInterval = 1; // 匹配尝试间隔(秒)
    private boolean isRunning = true;
    
    // 匹配线程池
    private final ExecutorService matchExecutor = Executors.newFixedThreadPool(2);
    
    public RealtimeMatchmaker() {
        // 启动匹配线程
        startMatchThread();
    }
    
    // 添加玩家到队列 (线程安全)
    public void addPlayer(Player player) {
        queueLock.lock();
        try {
            matchQueue.add(player);
            System.out.println("[系统] " + player.id + " (MMR: " + player.mmr + ") 加入队列");
            matchCondition.signal(); // 通知匹配线程
        } finally {
            queueLock.unlock();
        }
    }
    
    // 玩家取消匹配 (线程安全)
    public boolean cancelMatch(String playerId) {
        queueLock.lock();
        try {
            return matchQueue.removeIf(p -> p.id.equals(playerId));
        } finally {
            queueLock.unlock();
        }
    }
    
    // 启动匹配线程
    private void startMatchThread() {
        matchExecutor.execute(() -> {
            while (isRunning) {
                try {
                    queueLock.lock();
                    try {
                        // 等待队列中有至少2名玩家
                        while (matchQueue.size() < 2 && isRunning) {
                            matchCondition.await(matchInterval, TimeUnit.SECONDS);
                        }
                        
                        if (!isRunning) break;
                        
                        // 尝试匹配
                        tryMatchPlayers();
                    } finally {
                        queueLock.unlock();
                    }
                    //Thread.sleep(matchInterval * 1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("匹配线程被中断");
                    break;
                }
            }
        });
    }
    
    // 核心匹配逻辑 (需要在锁内调用)
    private void tryMatchPlayers() {
        if (matchQueue.size() < 2) return;
        
        List<Player> tempList = new ArrayList<>(matchQueue);
        Player firstPlayer = tempList.get(0);
        
        // 寻找最佳匹配
        Player bestMatch = null;
        int smallestDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < tempList.size(); i++) {
            Player candidate = tempList.get(i);
            int mmrDiff = Math.abs(firstPlayer.mmr - candidate.mmr);
            
            // 计算动态匹配范围
            long waitTimeSec = (System.currentTimeMillis() - firstPlayer.queueTime) / 1000;
            int dynamicRange = (int)(baseMatchRange * (1 + waitTimeSec / (double)maxWaitTime));
            
            if (mmrDiff <= dynamicRange && mmrDiff < smallestDiff) {
                bestMatch = candidate;
                smallestDiff = mmrDiff;
            }
        }
        
        // 如果找到匹配
        if (bestMatch != null) {
            firstPlayer.isMatched = true;
            bestMatch.isMatched = true;
            
            matchQueue.remove(firstPlayer);
            matchQueue.remove(bestMatch);
            
            System.out.println(Thread.currentThread().getName()+"[匹配成功] " + firstPlayer.id + " (MMR: " + firstPlayer.mmr +
                              ") vs " + bestMatch.id + " (MMR: " + bestMatch.mmr + 
                              ") | 等待时间: " + ((System.currentTimeMillis() - firstPlayer.queueTime)/1000) + "秒");
            
            // 这里可以调用回调函数或发送事件通知游戏服务器
        }
    }
    
    // 关闭匹配系统
    public void shutdown() {
        isRunning = false;
        matchExecutor.shutdown();
        try {
            if (!matchExecutor.awaitTermination(2, TimeUnit.SECONDS)) {
                matchExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            matchExecutor.shutdownNow();
        }
        System.out.println("匹配系统已关闭");
    }
    
    // 测试用例
    public static void main(String[] args) throws InterruptedException {
        RealtimeMatchmaker matchmaker = new RealtimeMatchmaker();
        
        // 模拟玩家加入
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                int mmr = 1000 + new Random().nextInt(500);
                matchmaker.addPlayer(new Player("玩家"+i, mmr));
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // 运行一段时间后关闭
        //Thread.sleep(15000);
        //matchmaker.shutdown();
    }
}
