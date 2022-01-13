package my.nio.bio;

import my.nio.NioClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu peng bo
 * @date 2022/1/10 下午4:26
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try (Socket client = new Socket("localhost", 6667)) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " " + System.currentTimeMillis() / 1000 + " 连接服务端！");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    bufferedReader.lines().forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
