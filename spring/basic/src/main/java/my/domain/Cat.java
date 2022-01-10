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

    public void print(){
        System.out.println("cat");
    }
}
