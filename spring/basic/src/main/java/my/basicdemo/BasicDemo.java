package my.basicdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:21 上午
 */
public class BasicDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(BasicDemoConfig.class);
        //ComponentDemo componentDemo = ac.getBean(ComponentDemo.class);
        ComponentDemo componentDemo = (ComponentDemo)ac.getBean("componentDemo");
        componentDemo.demo();
    }
}
