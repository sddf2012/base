package my.base.primitive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2022/1/6 下午1:37
 */
public class TestInt {
    public static void main(String[] args) {
        m1();
    }

    public static  void m1(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));

        int i=1000;
        int i2=1000;
        System.out.println("i==i2:"+(i==i2));
    }

    public static void m2(){
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(1000);
        list.remove((Object)10);
        list.remove(new Integer(1000));
        System.out.println(list.size());
    }
}
