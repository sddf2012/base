package my.base.extend;

/**
 * @author liu peng bo
 * @date 2022-10-10 10:12
 */
public class InnerDemo {
   public class InnerA{

    }
    static class InnerB{

    }

    void m1(){
        InnerA innerA=new InnerA();
        InnerA innerA2=new InnerA();
        System.out.println(innerA==innerA2);

    }

    public static void main(String[] args) {
        InnerDemo innerDemo=new InnerDemo();
        //InnerDemo.InnerA innerA=new InnerDemo.InnerA();
        InnerDemo.InnerB innerb=new InnerDemo.InnerB();
        InnerDemo.InnerB innerc=new InnerDemo.InnerB();
        System.out.println(innerc==innerb);
        innerDemo.m1();
    }
}
