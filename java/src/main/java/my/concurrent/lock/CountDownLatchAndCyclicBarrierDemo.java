package my.concurrent.lock;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liu peng bo
 * @date 2022/1/13 下午5:39
 */
public class CountDownLatchAndCyclicBarrierDemo {

    static class Student implements Runnable {
        private CountDownLatch countDownLatch;

        private CyclicBarrier cyclicBarrier;

        public Student(CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier) {
            this.countDownLatch = countDownLatch;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "开始答题!");
            System.out.println(Thread.currentThread().getName() + "答题完毕!");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        CountDownLatch countDownLatch = new CountDownLatch(n);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, () -> System.out.println("所有学生都准备完毕,考试开始!"));
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new Student(countDownLatch, cyclicBarrier));
            thread.start();
        }
        countDownLatch.await();
        System.out.println("考试结束!");

    }
}
