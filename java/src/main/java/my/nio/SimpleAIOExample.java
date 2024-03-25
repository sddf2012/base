package my.nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class SimpleAIOExample {

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // 替换为你的文件路径

        try (AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                Paths.get(filePath), StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024); // 创建一个容量为1024字节的ByteBuffer
            Future<Integer> operation = fileChannel.read(buffer, 0); // 异步读取文件，从位置0开始

            // 等待异步操作完成
            while (!operation.isDone()) ;

            // 读取完成后，准备从ByteBuffer中读取数据
            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            System.out.println(new String(data));
            buffer.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
