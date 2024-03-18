package my.algorithm.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TokenBucketLimiter {
    // 上一次令牌发放时间
    public long lastTime = System.currentTimeMillis();
    // 桶的容量
    public int capacity = 4;
    // 令牌生成速度 /s
    public int rate = 1;
    // 当前令牌数量
    public AtomicInteger tokens = new AtomicInteger(0);

    public TokenBucketLimiter() {
        // 初始化令牌数量
        tokens.set(capacity);
    }

    //返回值说明：
    // false 没有被限制到
    // true 被限流
    public synchronized boolean isLimited(long taskId, int applyCount) {
        long now = System.currentTimeMillis();
        //时间间隔,单位为 ms
        long gap = now - lastTime;

        //计算时间段内的令牌数
        int reverse_permits = (int) (gap * rate / 1000);
        int all_permits = tokens.get() + reverse_permits;
        all_permits=Math.min(capacity, all_permits);
        // 当前令牌数
        //tokens.set(Math.min(capacity, all_permits));
        log.info("tokens {} all_permits {} gap {} ", tokens, all_permits, gap);
        //lastTime = now;

        if (all_permits < applyCount) {
            // 若拿不到令牌,则拒绝
            // log.info("被限流了.." + taskId + ", applyCount: " + applyCount);
            return true;
        } else {
            // 还有令牌，领取令牌
            tokens.set( all_permits- applyCount);
            lastTime = now;

            // log.info("剩余令牌.." + tokens);
            return false;
        }

    }

    public static void main(String[] args) {
        TokenBucketLimiter tokenBucketLimiter = new TokenBucketLimiter();
        tokenBucketLimiter.testLimit();
    }

    //线程池，用于多线程模拟测试
    private  ExecutorService pool = Executors.newFixedThreadPool(10);

    public  void testLimit() {

        // 被限制的次数
        AtomicInteger limited = new AtomicInteger(0);
        // 线程数
        final int threads = 2;
        // 每条线程的执行轮数
        final int turns = 20;


        // 同步器
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            pool.submit(() ->
            {
                try {

                    for (int j = 0; j < turns; j++) {

                        long taskId = Thread.currentThread().getId();
                        boolean intercepted = isLimited(taskId, 1);
                        if (intercepted) {
                            // 被限制的次数累积
                            limited.getAndIncrement();
                        }

                        Thread.sleep(1000);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                //等待所有线程结束
                countDownLatch.countDown();

            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float time = (System.currentTimeMillis() - start) / 1000F;
        //输出统计结果

        log.info("限制的次数为：" + limited.get() +
                ",通过的次数为：" + (threads * turns - limited.get()));
        log.info("限制的比例为：" + (float) limited.get() / (float) (threads * turns));
        log.info("运行的时长为：" + time);
    }


}