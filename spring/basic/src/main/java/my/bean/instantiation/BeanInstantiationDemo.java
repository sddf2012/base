package my.bean.instantiation;

import my.domain.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author liu peng bo
 * @date 2021/10/14 3:46 下午
 */
@Import(CatFactoryBean.class)
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanInstantiationDemo.class);
        Cat cat = ac.getBean(Cat.class);
        CatFactoryBean catFactoryBean = ac.getBean(CatFactoryBean.class);
        System.out.println(cat);
        System.out.println(catFactoryBean);
    }
}
