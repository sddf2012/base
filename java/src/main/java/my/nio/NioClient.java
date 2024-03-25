package my.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu peng bo
 * @date 2022/1/10 下午3:55
 */
public class NioClient {

    public static void client() {
        try {
            String name = Thread.currentThread().getName();
            //得到一个网络通道
            SocketChannel socketChannel = SocketChannel.open();
            //设置为非阻塞
            socketChannel.configureBlocking(false);
            //提供服务器端的IP和端口
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
            //连接服务器
            if (!socketChannel.connect(inetSocketAddress)) {
                while (!socketChannel.finishConnect()) {
                    System.out.println(name + " 连接中...");
                }
            }

            //接受服务端消息
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = socketChannel.read(byteBuffer);
                        if (read > 0) {
                            byteBuffer.flip();
                            byte[] bytes = new byte[byteBuffer.limit()];
                            byteBuffer.get(bytes);
                            System.out.println(name + " " + System.currentTimeMillis() + " 收到服务端消息:" + new String(bytes));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            //连接成功,发送数据
            System.out.println(name + " " + System.currentTimeMillis() + " 连接成功");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
                if ("exit".equals(msg)) {
                    socketChannel.close();
                    System.out.println(name + " " + System.currentTimeMillis() + " 客户端退出");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(NioClient::client);
        }*/
        client();

    }
}
