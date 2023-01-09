package my.base.primitive.string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * @author liu peng bo
 * @date 2022-7-6 15:18
 */
public class TestString {
    public static void main(String[] args) {

        /*System.out.println(System.currentTimeMillis());
        String failId=String.valueOf(System.currentTimeMillis())+ new Random().nextInt(1000);
        System.out.println(failId);
        System.out.println(Long.toHexString(Long.parseLong(failId)));*/
        /*System.out.println(String.format("%s,123,%s", "a", null));
        String[] params="1, ".split(",");
        System.out.println(params.length);
        System.out.println(Arrays.toString(params));
    int i=3;
        System.out.println(String.format("%09d", i + 1));*/
        System.out.println("啊".getBytes(StandardCharsets.UTF_8).length);
        String a=null;
        System.out.println("bbbb"+a);
    }
}