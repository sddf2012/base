package my.nio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
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
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
            //连接服务器
            if (!socketChannel.connect(inetSocketAddress)) {
                while (!socketChannel.finishConnect()) {
                    System.out.println(name + " 连接需要时间,客户端不会阻塞...先去吃个宵夜");
                }
            }
            //连接成功,发送数据
            System.out.println(name + " " + System.currentTimeMillis() + " 连接成功");
            String str = "hello,Java菜鸟程序员";
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
            socketChannel.write(byteBuffer);
            socketChannel.close();
            System.out.println(name +  " " + System.currentTimeMillis() +" 客户端退出");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(NioClient::client);
        }

    }
}
