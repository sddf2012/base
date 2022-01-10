package my.bean.definition;

import my.domain.Cat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:03 上午
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Cat.class);
        builder.addPropertyValue("age", 2).addPropertyValue("name", "tom");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition.getBeanClassName());

    }
}
