package my.bean.definition;

import my.domain.Cat;
import my.domain.LiHuaCat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:03 上午
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        mergedBeanDefinition();
    }

    private static void basic() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Cat.class);
        builder.addPropertyValue("age", 2).addPropertyValue("name", "tom");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition.getBeanClassName());
    }

    private static void mergedBeanDefinition() {
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
        BeanDefinitionBuilder catBuilder = BeanDefinitionBuilder.genericBeanDefinition(Cat.class);
        catBuilder.addPropertyValue("age", 2).addPropertyValue("name", "tom");
        registry.registerBeanDefinition("cat", catBuilder.getBeanDefinition());

        BeanDefinitionBuilder builder2 = BeanDefinitionBuilder.genericBeanDefinition(LiHuaCat.class);
        builder2.setParentName("cat");
        builder2.addPropertyValue("address", "shanghai");
        registry.registerBeanDefinition("lihuaCat", builder2.getBeanDefinition());


        Cat cat = registry.getBean("cat",Cat.class);
        LiHuaCat liHuaCat = registry.getBean(LiHuaCat.class);

        System.out.println(cat.toString());
        System.out.println(liHuaCat.toString());


    }
}
