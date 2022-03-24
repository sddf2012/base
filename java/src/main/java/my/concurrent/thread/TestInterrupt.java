package my.concurrent.thread;


import lombok.SneakyThrows;

/**
 * @author liu peng bo
 * @date 2022/1/13 下午4:04
 */
public class TestInterrupt {
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(1);
                System.out.println("status:" + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("status after interrupt():" + Thread.currentThread().isInterrupted());
                //Thread.sleep(100);
                System.out.println(2);
                System.out.println("interrupted and return:" + Thread.interrupted());
                System.out.println("status after Thread.interrupted():" + Thread.currentThread().isInterrupted());
                Thread.sleep(100);
                System.out.println(3);
                System.out.println("interrupted and return:" + Thread.interrupted());
                System.out.println("status after Thread.interrupted():" + Thread.currentThread().isInterrupted());
                System.out.println(4);
            }
        });
        a.start();
    }
}
