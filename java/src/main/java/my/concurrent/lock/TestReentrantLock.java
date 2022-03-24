package my.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu peng bo
 * @date 2022/1/13 下午3:39
 */
public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"获取了锁!");
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        a.start();
        b.start();
        a.join();

    }
}
