package my.initsequence;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liu peng bo
 * date: 2021/7/23 11:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InitSon extends InitParent {

    public InitSon() {
        //super(1, 2);
        System.out.println("son 无参构造函数");
    }

    public InitSon(int a, int b) {
        super(a, b);
        System.out.println("son 有参构造函数");
    }

    public static void main(String[] args) {
        new InitSon(2, 3);
    }
}
