package my.bean.circulardependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2022/5/18 下午5:30
 */
@Configuration
@ComponentScan("my.bean.circulardependency")
public class CircularDependencyDemo {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(CircularDependencyDemo.class);
        System.out.println(ac.getBean(CdA.class));
        System.out.println(ac.getBean(CdB.class));

    }
}
