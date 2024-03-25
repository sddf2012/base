package my.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author liu peng bo
 * @date 2022/1/10 下午7:27
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer);
        buffer.put("炉石传说".getBytes());
        System.out.println(buffer);
        buffer.flip();
        System.out.println(buffer);
        byte[] array = buffer.array();
        System.out.println("length:" + array.length);
        System.out.println(new String(buffer.array()));
        buffer.clear();
        buffer.put("魔兽争霸".getBytes());
        System.out.println("length:" + array.length);
        System.out.println(new String(buffer.array()));
        //直接返回底层的数组
        //System.out.println(new String(buffer.array(),0,buffer.limit(), StandardCharsets.UTF_8));
        /*byte[] content = new byte[buffer.remaining()];
        buffer.get(content, 0, buffer.remaining());
        System.out.println(new String(content));
        System.out.println(buffer);
        buffer.compact();
        System.out.println(buffer);*/
    }
}
