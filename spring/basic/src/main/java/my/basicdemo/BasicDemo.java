package my.basicdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:21 上午
 */
public class BasicDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BasicDemoConfig.class);
        //ComponentDemo componentDemo = ac.getBean(ComponentDemo.class);
        ConfigurableListableBeanFactory beanFactory = ac.getBeanFactory();
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (int i = 0; i < definitionNames.length; i++) {
            System.out.println(definitionNames[i] + ":" + beanFactory.getBeanDefinition(definitionNames[i]).getClass());
        }
        ComponentDemo componentDemo = (ComponentDemo) ac.getBean("componentDemo");
        componentDemo.demo();
    }
}
