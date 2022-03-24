package my.concurrent.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu peng bo
 * @date 2022/1/17 下午3:31
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(5);
        service.submit(()->{
            System.out.println("123");
        });
    }
}
