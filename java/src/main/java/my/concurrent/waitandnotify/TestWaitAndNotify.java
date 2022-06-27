package my.concurrent.waitandnotify;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liu peng bo
 * @date 2022/1/12 下午2:18
 */
public class TestWaitAndNotify {
    private Queue<Integer> queue = new ArrayBlockingQueue<>(100);

    synchronized void consume() throws InterruptedException {
        String name = "consume";
        while (true) {
            long begin = System.currentTimeMillis();
            System.out.println("consume 开始等待!");
            if (queue.isEmpty()) {
                wait();

            }
            long end = System.currentTimeMillis();
            System.out.println(end - begin + " 毫秒后consume 继续执行!");
            if (!queue.isEmpty()) {
                System.out.println("poll:" + queue.poll());
            }
        }
    }

    synchronized void produce(int i) throws InterruptedException {
        queue.add(i);
        notifyAll();
    }

    static class ThreadA implements Runnable {
        TestWaitAndNotify testWaitAndNotify;

        public ThreadA(TestWaitAndNotify waitAndNotify) {
            this.testWaitAndNotify = waitAndNotify;
        }

        @SneakyThrows
        @Override
        public void run() {
            testWaitAndNotify.consume();
        }
    }

    static class ThreadB implements Runnable {
        TestWaitAndNotify testWaitAndNotify;

        public ThreadB(TestWaitAndNotify waitAndNotify) {
            this.testWaitAndNotify = waitAndNotify;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                testWaitAndNotify.produce(i);
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestWaitAndNotify testWaitAndNotify = new TestWaitAndNotify();
        Thread a = new Thread(new ThreadA(testWaitAndNotify));
        Thread b = new Thread(new ThreadB(testWaitAndNotify));
        a.start();
        b.start();
        b.join();

    }
}
