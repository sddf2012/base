package my.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu peng bo
 * date: 2021/6/23 11:10
 */
public class ConcurrentOperation {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);
    private static int i = 0;
    private static void plusplus() {
        i++;
    }
    private static void atomicAdd() {
        atomicInteger.getAndIncrement();
    }

    private static void testAtomic() throws Exception {

        ExecutorService executor = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new MyThreadFactory("plus"));
        int size = 50000;
        CountDownLatch latch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            executor.submit(() -> {
                plusplus();
                atomicAdd();
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("i:" + i);
        System.out.println("atomicInteger:" + atomicInteger.get());
    }

    public static void main(String[] args) throws Exception {
        testAtomic();
    }
}
