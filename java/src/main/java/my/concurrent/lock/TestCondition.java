package my.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu peng bo
 * @date 2022/1/14 下午8:30
 */
public class TestCondition {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        condition.await();
    }
}
