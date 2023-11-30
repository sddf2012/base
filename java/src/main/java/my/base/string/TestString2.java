package my.base.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author liu peng bo
 * @date 2022/1/8 下午2:11
 */
public class TestString2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
       // m2();
        Object a=null;
        String b=(String) a;
        System.out.println(b);
    }

    public static void m1(){
        System.out.println(String.format("%02d",1));
        System.out.println(String.format("%02d",9));
        System.out.println(String.format("%02d",10));
        System.out.println(String.format("%02d",11));
    }

    public static void m2(){
        StringBuilder s=new StringBuilder();
        //s.append("a").append(",");
        System.out.println(s.length()>0);
    }
}
