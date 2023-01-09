package my.base.hashandequal;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu peng bo
 * @date 2022-9-28 11:16
 */
@Data
class EqualA {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

public class EqualDemo {
    public static void main(String[] args) {
        EqualA equalA=new EqualA();
        equalA.setA("1");
        EqualA equalA2=new EqualA();
        equalA2.setA("1");
        System.out.println(equalA2.equals(equalA));
        Set<EqualA> set=new HashSet<>();
        set.add(equalA2);
        set.add(equalA);
        System.out.println(set.size());
    }
}
