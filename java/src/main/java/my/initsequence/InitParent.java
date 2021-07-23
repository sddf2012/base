package my.initsequence;

import lombok.Data;

/**
 * @author liu peng bo
 * date: 2021/7/23 11:39
 */
@Data
public class InitParent {
    private int a;

    private int b;

    public InitParent() {
        System.out.println("parent 无参构造函数");
    }

    public InitParent(int a, int b) {
        System.out.println("parent 有参构造函数");
        System.out.println("a=" + a + " b=" + b);
        this.a = a;
        this.b = b;
    }
}
