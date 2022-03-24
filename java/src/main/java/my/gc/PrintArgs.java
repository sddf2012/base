package my.gc;

/**
 * @author liu peng bo
 * @date 2022/1/17 下午6:56
 */
public class PrintArgs {
    public static void main(String[] args) {
        String result = System.getProperty("argname");
        System.out.println("argname: " + result);
    }
}
