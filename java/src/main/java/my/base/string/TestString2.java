package my.base.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liu peng bo
 * @date 2022/1/8 下午2:11
 */
public class TestString2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println("我".length());
//        System.out.println("\uD85D\uDE0C".length());
//        System.out.println(new String("我".getBytes(), StandardCharsets.UTF_8).length());
//        System.out.println(new String("我".getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16).length());
//        byte[] a="我".getBytes();
//        byte[] b="我".getBytes(StandardCharsets.UTF_8);
//        byte[] c="我".getBytes(StandardCharsets.UTF_16);
//        System.out.println(1);


        System.out.println("a".getBytes().length);
        System.out.println("我".getBytes(StandardCharsets.UTF_16).length);
        System.out.println("\uD85D\uDE0C".getBytes().length);
        System.out.println("😭".getBytes().length);
    }
}
