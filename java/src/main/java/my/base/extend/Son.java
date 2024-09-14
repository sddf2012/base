package my.base.extend;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liu peng bo
 * @date 2024/09/14 15:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Son extends Father{
    private String age;

    public Son() {
        System.out.println("son");
        this.age = age;
    }

    public Son(String age) {
        System.out.println("son age");
        this.age = age;
    }

    public Son(String name,String age) {
        super(name);
        System.out.println("son name age");
        this.age = age;
    }
}
