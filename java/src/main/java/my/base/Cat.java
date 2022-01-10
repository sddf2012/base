package my.base;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2022/1/3 上午10:55
 */
@Data
public class Cat {
    public String name;

    public String sex;

    public int age;

    public Cat() {
    }

    public Cat(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
