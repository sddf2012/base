package my.base.primitive.string;

import java.util.Random;

/**
 * @author liu peng bo
 * @date 2022-7-6 15:18
 */
public class TestString {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        String failId=String.valueOf(System.currentTimeMillis())+ new Random().nextInt(1000);
        System.out.println(failId);
        System.out.println(Long.toHexString(Long.parseLong(failId)));

    }
}