package my.base.trans;

/**
 * @author liu peng bo
 * @date 2023/11/10 15:59
 */
public class TransDemo {
    public void m1(String a) {
        System.out.println("a:" + a);
        a = "m1";
    }

    public void m2(Integer a) {
        System.out.println("a:" + a);
        a = 2;
        System.out.println(a);
    }

    public static void main(String[] args) {
        String s="main";
        Integer i=1;
        TransDemo transDemo=new TransDemo();
        //transDemo.m1(s);
        transDemo.m2(i);
        System.out.println(i);
    }
}
