package my.base.extend;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * @author liu peng bo
 * @date 2022-7-18 16:07
 */
//@Data
class E1{
    private String a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        E1 e1 = (E1) o;
        return Objects.equals(a, e1.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
//@Data
//@EqualsAndHashCode(callSuper = true)
class E2 extends E1{
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
public class EqualDemo {
    public static void main(String[] args) {
         E1 a=new E1();
         a.setA("a");
         E2 b=new E2();
         b.setA("a");
         b.setB("b");
        System.out.println(a.equals(b));
    }
}
