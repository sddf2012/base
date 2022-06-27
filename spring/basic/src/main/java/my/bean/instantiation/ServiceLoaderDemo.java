package my.bean.instantiation;

import my.domain.factory.CatFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * @author liu peng bo
 * @date 2021/10/14 4:04 下午
 */
public class ServiceLoaderDemo {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:/serviceloader.xml");
        ServiceLoader<CatFactory> serviceLoader=ac.getBean("catFactoryServiceLoader",ServiceLoader.class);
        for (CatFactory catFactory : serviceLoader) {
            System.out.println(catFactory.createCat());
        }
        //jdkServiceLoader();
    }

    public static void jdkServiceLoader() {
        ServiceLoader<CatFactory> serviceLoader = ServiceLoader.load(CatFactory.class, Thread.currentThread().getContextClassLoader());
        for (CatFactory catFactory : serviceLoader) {
            System.out.println(catFactory.createCat());
        }
    }

}
