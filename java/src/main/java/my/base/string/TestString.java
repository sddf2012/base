package my.base.string;

/**
 * @author liu peng bo
 * @date 2022/1/3 下午4:35
 */
public class TestString {
    public static void basic(){
        System.out.println();//2121
        System.out.println("1");//2122
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2131
        //如下的字符串"1" 到 "10"不会再次加载
        System.out.println("1");//2132
        System.out.println("2");//2132
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2132
    }

    /**
     * 何时在常量池中生成
     */
    public static void basic2(){
        //常量池中创建了1个对象
        /*new String ("a");
        //未创建对象
        String s="a";*/



        //在常量池中生成 ab，不会生成a和b
        /*String s="a"+"b";
        //常量池中已存在，不会再次创建
        String s1="ab";
        //在常量池中生成a
        String s2="a";
        //true
        System.out.println(s==s1);*/



        //堆和常量池中均创建对象a
        /*String s=new String ("a");
        //常量池中已存在，不会再次创建
        String s1="a";
        //false  因为s为堆中的引用，s1为常量池中的引用，两个不一样
        System.out.println(s==s1);*/



        //jvm会优化，堆和常量池中均创建对象ab，不会创建a和b
        /*String s=new String ("a"+"b");
        //常量池中已存在，不会再次创建
        String s1="ab";
        //常量池中不存在，创建a
        String s2="a";
        //false
        System.out.println(s==s1);*/



        //创建了3个对象，堆中ab，常量池中a,b.  为何堆中无a? 猜测：根据最上面的例子，如果没有具体的引用指向该实例，不会在堆中创建对象
        /*String s=new String("a")+"b";
        //常量池中已经存在，不会再创建b
        String s2="b";
        //常量池中已经存在，不会再创建a
        String s3="a";
        //常量池中创建ab
        String s1="ab";
        //false
        System.out.println(s==s1);*/


        //创建1个堆对象ab；两个常量池对象a，b
        /*String  s=new String("a")+new String("b");
        //此处常量池不会创建新的ab，直接使用s的引用
        //s.intern();
        //常量池中创建ab，如果上面未注释，则常量池不会创建新的，直接返回s的引用
        String s1="ab";
        //常量池中已经存在，不会再创建a,b
        String s2="a";
        String s3="b";
        //false 如果s.intern()未注释，则为true
        System.out.println(s==s1);*/



        String s="a";
        String s1="b";
        //堆中创建ab
        String s2=s+s1;
        //常量池中创建ab
        String s3="ab";
        //false
        System.out.println(s2==s3);
    }

    public static void m1(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        //s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void m2(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
    public static void main(String[] args) {
        basic2();
        //basic();
        //m1();
        //m2();
    }
}
