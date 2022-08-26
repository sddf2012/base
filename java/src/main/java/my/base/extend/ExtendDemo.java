package my.base.extend;

import my.domain.Cat;
import my.domain.CatFamily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2022-8-11 10:10
 */
public class ExtendDemo {
    public static void main(String[] args) {
        m1();
    }

    public static void m1(){
        List<Cat> cats=new ArrayList<>();
        cats.add(new Cat("tom","1",1));
        Object o=cats;
        List<CatFamily> catFamilies=(List<CatFamily>)o;
        System.out.println(1);
    }
}
