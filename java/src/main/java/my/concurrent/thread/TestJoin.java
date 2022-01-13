package my.concurrent.thread;

import lombok.SneakyThrows;

/**
 * @author liu peng bo
 * @date 2022/1/12 下午2:31
 */
public class TestJoin {

    static class ThreadJoin extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 1; i < 7; i++) {
                System.out.println(name + " begin sleep " + i);
                    Thread.sleep(1000);
                    if(i==3){
                        interrupt();
                    }

            }
            System.out.println(name + " end!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        //Thread.currentThread().interrupt();
        threadJoin.start();
        threadJoin.join();
        System.out.println("main thread end!");
    }
}
