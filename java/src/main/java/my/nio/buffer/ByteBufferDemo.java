package my.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author liu peng bo
 * @date 2022/1/10 下午7:27
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.toString());
        byteBuffer.put("炉石传说".getBytes());
        System.out.println(byteBuffer.toString());
        byteBuffer.flip();
        System.out.println(byteBuffer.toString());
        //直接返回底层的数组
        //System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit(), StandardCharsets.UTF_8));
        byte[] content = new byte[byteBuffer.remaining()];
        byteBuffer.get(content, 0, byteBuffer.remaining());
        System.out.println(new String(content));
        System.out.println(byteBuffer.toString());
        byteBuffer.compact();
        System.out.println(byteBuffer.toString());
    }
}
