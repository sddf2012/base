package my.domain;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:04 上午
 */
@Data
public class Cat {
    public String name;

    public int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println(this.toString());
    }

    public static Cat createCat() {
        Cat cat = new Cat();
        cat.setName("maomi");
        cat.setAge(2);
        return cat;
    }
}
