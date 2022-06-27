package my.bean.initialize;

import my.bean.instantiation.MyInstantiationPostProcessor;
import my.domain.factory.CatFactory;
import my.domain.factory.DefaultCatFactory;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author liu peng bo
 * @date 2021/10/14 4:42 下午
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanInitializationDemo.class);
        //ac.getBean(CatFactory.class);
        System.out.println("ac准备关闭！");
        ac.close();
        System.out.println("ac已关闭！");
    }

    //@Lazy
    @Bean(initMethod = "customizedInit", destroyMethod = "customizedDestroy")
    public CatFactory catFactory() {
        return new DefaultCatFactory();
    }

    @Bean
    public MyInstantiationPostProcessor postProcessor(){
        return new MyInstantiationPostProcessor();
    }
}
