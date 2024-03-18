package my.algorithm.base;

import java.util.Date;
import java.util.LinkedList;

public class SlidingLogRateLimiter {
    // 存储时间戳的列表
    private final LinkedList<Long> requestTimestamps = new LinkedList<>();
    // 时间窗口大小，例如1分钟（60000毫秒）
    private final long timeWindow;
    // 时间窗口内允许的最大请求量
    private final int maxRequests;

    public SlidingLogRateLimiter(int maxRequests, long timeWindowInMillis) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindowInMillis;
    }

    /**
     * 尝试执行请求。
     *
     * @return 如果请求在速率限制内，则为true；否则为false。
     */
    public synchronized boolean tryRequest() {
        long now = System.currentTimeMillis();
        
        // 移除时间窗口之前的所有请求记录
        while (!requestTimestamps.isEmpty() && now - requestTimestamps.peek() > timeWindow) {
            requestTimestamps.poll();
        }

        // 检查当前时间窗口内的请求量是否超过了限制
        if (requestTimestamps.size() < maxRequests) {
            // 在限制内，记录这次请求的时间戳，然后允许请求
            requestTimestamps.add(now);
            return true;
        } else {
            // 超过限制，拒绝请求
            return false;
        }
    }

    public static void main(String[] args) {
        // 创建一个速率限制器，例如：每分钟允许最多10个请求
        SlidingLogRateLimiter rateLimiter = new SlidingLogRateLimiter(10, 25000);

        // 模拟请求
        for (int i = 0; i < 50; i++) {
            boolean allowed = rateLimiter.tryRequest();
            System.out.println(new Date()+" Request " + (i + 1) + ": " + (allowed ? "allowed" : "denied"));
            try {
                // 模拟请求间隔时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}