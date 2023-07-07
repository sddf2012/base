package my.classload;

/**
 * @author liu peng bo
 * @date 2023/07/05 14:45
 */
public class ClassLoadDemo {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("sun.boot.class.path"));
       // System.out.println(System.getProperty("java.ext.dirs"));
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 获取系统类加载器的父类加载器 --> 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        // 获取扩展类加载器的父类加载器 --> 根加载器（C/C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        // 测试当前类的加载器
        ClassLoader classLoader = ClassLoadDemo.class.getClassLoader();
        System.out.println(classLoader);
        // 测试JDK内置的类加载器
        classLoader = Object.class.getClassLoader();
        System.out.println(classLoader);
        // 如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));


    }
}
