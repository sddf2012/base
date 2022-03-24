package my.concurrent.lock;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @author liu peng bo
 * @date 2022/1/14 下午4:08
 */
public class DeadlockDemo {
    private final static Object object1 = new Object();
    private final static Object object2 = new Object();

    static void method1() {
        synchronized (object1) {
            try {
                System.out.println(Thread.currentThread().getName()+" run method1");
                Thread.sleep(2000);
                method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void method2() {
        synchronized (object2) {
            try {
                System.out.println(Thread.currentThread().getName()+" run method2");
                Thread.sleep(2000);
                method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }, "thread-a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }, "thread-b");
        a.start();
        b.start();

    }
}
