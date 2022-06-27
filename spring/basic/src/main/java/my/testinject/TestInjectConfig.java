package my.testinject;

import my.domain.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2022/3/30 下午7:47
 */
@Configuration
public class TestInjectConfig {
    @Bean
    public Cat cat() {
        return new Cat("c1", 1);
    }

    @Bean
    @TestInject
    public Cat cat1() {
        return new Cat("c2", 2);
    }

    @Bean
    public CatList cats1(List<Cat> cats) {
        CatList catList = new CatList();
        catList.setCats(cats);
        return catList;
    }

    @Bean
    public CatList cats2(@TestInject List<Cat> cats) {
        CatList catList = new CatList();
        catList.setCats(cats);
        return catList;
    }

    @TestInject
    @Autowired
    private List<Cat> cats3=new ArrayList<>();

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestInjectConfig.class);
        System.out.println(ac.getBean("cats1", CatList.class).size());
        System.out.println(ac.getBean("cats2", CatList.class).size());
        System.out.println(ac.getBean(TestInjectConfig.class).cats3.size());
    }
}
