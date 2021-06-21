package my.functional;

/**
 * 函数式接口，只能有一个抽象方法，默认和静态不算在内.
 * FunctionalInterface 注解只是告诉编译器需要检查该接口是否满足函数式接口条件，不满足则报错
 * 如果一个接口满足函数式条件，加不加注解没有区别
 *
 * @author liu peng bo
 * date: 2020/6/2 16:23
 */
@FunctionalInterface
public interface Animal {

    String getName();

    default String getCategory() {
        return "动物";
    }

    static void eat() {
        System.out.println("1232");
    }
}
