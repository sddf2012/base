package my.algorithm.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {
    private long windowTime;
    private int maxRequest;
    private int windowCount;

    private long perWindowTime;
    private List<SubWindow> windows;

    class SubWindow {
        private Long begin;

        private int request;
    }

    public SlidingWindowRateLimiter(long windowTime, int maxRequest, int windowCount) {
        this.windowTime = windowTime;
        this.maxRequest = maxRequest;
        this.windowCount = windowCount;
        this.perWindowTime = windowTime / windowCount;
        this.windows = new ArrayList<>();
    }

    private synchronized boolean tryRequest() {
        long current = System.currentTimeMillis();
        long minTime = current - this.windowTime;
        Iterator<SubWindow> iterator = this.windows.iterator();
        int totalRequest = 0;
        while (iterator.hasNext()) {
            SubWindow subWindow = iterator.next();
            if (subWindow.begin < minTime) {
                iterator.remove();
            } else {
                totalRequest = totalRequest + subWindow.request;
            }
        }
        if (totalRequest >= maxRequest) {
            return false;
        }
        int size = windows.size();
        if (size == 0) {
            SubWindow subWindow = new SubWindow();
            subWindow.begin = current;
            subWindow.request = 1;
            windows.add(subWindow);
        } else {
            SubWindow lastSubWindow = windows.get(size - 1);
            if (current - lastSubWindow.begin < perWindowTime) {
                lastSubWindow.request++;
            } else {
                SubWindow subWindow = new SubWindow();
                subWindow.begin = current;
                subWindow.request = 1;
                windows.add(subWindow);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(30000L, 10, 10);

        // 模拟请求
        for (int i = 0; i < 50; i++) {
            boolean allowed = rateLimiter.tryRequest();
            System.out.println(new Date() + " Request " + (i + 1) + ": " + (allowed ? "allowed" : "denied") + " windows size:" + rateLimiter.windows.size());
            try {
                // 模拟请求间隔时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
