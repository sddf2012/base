package my.bean.instantiation;

import my.domain.Cat;
import my.domain.factory.DefaultCatFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author liu peng bo
 * @date 2021/10/14 3:46 下午
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        //ApplicationContext ac = instantiationByStaticFactoryMethod();
        //ApplicationContext ac = instantiationByBeanMethod();
        ApplicationContext ac = instantiationByFactoryBean();

        Cat cat = ac.getBean(Cat.class);
        cat.print();
    }

    public static ApplicationContext instantiationByStaticFactoryMethod() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Cat.class);
        //该静态实例方法只能在Cat类中，在其他类中会找不到
        builder.setFactoryMethod("createCat");
        ac.registerBeanDefinition("cat", builder.getBeanDefinition());
        ac.refresh();
        return ac;
    }

    public static ApplicationContext instantiationByBeanMethod() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.registerBeanDefinition("catFactory", catFactoryDefinition());

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Cat.class);
        builder.setFactoryMethodOnBean("createCat", "catFactory");
        ac.registerBeanDefinition("cat", builder.getBeanDefinition());
        ac.refresh();
        return ac;
    }

    public static BeanDefinition catFactoryDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DefaultCatFactory.class);
        return builder.getBeanDefinition();
    }

    public static ApplicationContext instantiationByFactoryBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CatFactoryBean.class);
        ac.registerBeanDefinition("cat", builder.getBeanDefinition());
        ac.refresh();
        return ac;
    }


}
