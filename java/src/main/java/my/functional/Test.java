package my.functional;

/**
 * @author liu peng bo
 * date: 2020/6/2 16:23
 */
public class Test {
    public static void main(String[] args) {
        FunctionDemo cat = () -> "cat";
        System.out.println(cat.getName());
    }
}
