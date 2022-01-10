package my.domain.factory;

import my.domain.Cat;

/**
 * @author liu peng bo
 * @date 2021/10/14 4:05 下午
 */
public interface CatFactory {
    default Cat createCat(){
        Cat cat=new Cat();
        cat.setName("jerry");
        cat.setAge(3);
        return cat;
    }
}
