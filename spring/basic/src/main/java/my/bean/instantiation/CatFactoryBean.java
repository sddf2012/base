package my.bean.instantiation;

import my.domain.Cat;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author liu peng bo
 * @date 2021/10/14 3:44 下午
 */
public class CatFactoryBean implements FactoryBean<Cat> {
    @Override
    public Cat getObject() {
        return new Cat("tom", 1);
    }

    @Override
    public Class<?> getObjectType() {
        return Cat.class;
    }
}
