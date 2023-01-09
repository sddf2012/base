package my.functional;

import org.apache.logging.log4j.util.Supplier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author liu peng bo
 * date: 2020/6/2 16:23
 */
public class Test {
    public static void main(String[] args) {
           //supplier(Test::test);
        /*Object a=null;
        Long b=(Long) a;
        System.out.println(b);*/
       test();
    }

    public static void supplier(Supplier<?> supplier) {
        System.out.println(supplier.getClass().getEnclosingMethod().getName());
    }

    public static void test() {
        Map<String , Object> map=new HashMap<>();
        map.put("1","123");
        map.put("2",234);
        String b=(String)map.get("2");
        String a=(String)map.get("1");
    }


}
