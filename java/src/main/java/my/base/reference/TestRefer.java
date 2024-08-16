package my.base.reference;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2024/05/22 10:17
 */
@Data
class Tr{
    private int i;
}
public class TestRefer {
    public static void main(String[] args) {
/*
        Tr tr = new Tr();
        tr.setI(1);
        Tr tr1 = tr;
        tr.setI(2);
        System.out.println(tr1.getI());
*/
        String  a="qwe";
        String  b=a;
        System.out.println(b==a);
        System.out.println(b.equals(a));
        a="wer";
        System.out.println(b==a);
        System.out.println(b.equals(a));
    }
}
