package my.classload;

/**
 * @author liu peng bo
 * @date 2023/07/05 14:31
 */
class  SuperClass{

    static {
        System.out.println("SuperClass init!");
    }
    public  static  int value=123;

    public static  final String HELLO = "hello";


}
class  SubClass extends  SuperClass{

    static {
        System.out.println("SubClass init!");
    }

}

public class InitDemo {
    public static void main(String[] args) {
        //通过其子类来引用父类中定义的静态字段，只会触发父类初始化而不会触发子类的初始化。至于是否要触发子类的加载和验证，这个在虚拟机规范中并没有明确规定，这点取决于虚拟机的具体实现
        //System.out.println(SubClass.value);

        //通过数组定义来引用类，不会触发此类的初始化
        //SuperClass[] sca=new SuperClass[10];

        //常量在编译阶段会存入调用类的常量池, 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        System.out.println(SuperClass.HELLO);


    }
}
