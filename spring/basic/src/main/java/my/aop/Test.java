package my.aop;

import my.aop.config.AnnotationConfiguration;
import my.aop.service.ClubService;
import my.aop.service.TestService2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * date: 2020/6/2 15:18
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
        ClubService clubService = ac.getBean(ClubService.class);
        //System.out.println(clubService.getName());
        TestService2 testService2 = ac.getBean(TestService2.class);
        testService2.test2();
    }
}
