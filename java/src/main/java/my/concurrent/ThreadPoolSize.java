package my.concurrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liu peng bo
 * date: 2021/6/23 15:11
 */
public class ThreadPoolSize {
    private static long cpuOperation() {
        long a = System.currentTimeMillis();
        /*double d=a*123.234234;
        int i = 0;
        while (i < 100) {
            d= Math.pow(d, 1.0/2);
            d=d*23434.546345;
            new BigDecimal(a).multiply(new BigDecimal(a));
            i++;
        }*/
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long b = System.currentTimeMillis();
        return b - a;
    }

    private static void cpu(int poolSize, int task) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                new MyThreadFactory("cpu"));
        CountDownLatch latch = new CountDownLatch(task);
        Vector<Long> list = new Vector<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < task; i++) {
            executor.submit(() -> {
                list.add(cpuOperation());
                latch.countDown();
            });
        }
        latch.await();
        long end = System.currentTimeMillis();
        long sum = 0L;
        for (Long aLong : list) {
            sum = sum + aLong;
        }
        System.out.println("线程池大小:" + poolSize);
        System.out.println("线程平均执行时间:" + (sum / list.size()));
        System.out.println("总耗时:" + (end - begin));
    }


    public static void main(String[] args) throws Exception {
        int task = 100;
        //for (int i = 2; i < 33; i++) {
            cpu(22, task);
        //}
    }
}
