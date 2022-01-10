package my.bean.lookup;

import my.domain.Cat;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liu peng bo
 * @date 2021/10/21 2:03 下午
 */
public class HierarchicalLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(HierarchicalLookupDemo.class);
        ConfigurableListableBeanFactory beanFactory= ac.getBeanFactory();
        System.out.println("parent:"+beanFactory.getParentBeanFactory());
        System.out.println(beanFactory.getBean("cat"));
        System.out.println(beanFactory.getBeanProvider(Cat.class).getIfAvailable());

        beanFactory.setParentBeanFactory(parentBeanFactory());
        System.out.println("parent:"+beanFactory.getParentBeanFactory());
        System.out.println(beanFactory.getBean("cat"));


    }

    private static ConfigurableListableBeanFactory parentBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/basic.xml");
        return beanFactory;
        /*ClassPathXmlApplicationContext ac=  new ClassPathXmlApplicationContext("classpath:/basic.xml");
        return ac.getBeanFactory();*/
    }
}
