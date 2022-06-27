package my.testimport;

import my.domain.Cat;
import my.domain.Dog;
import my.testimport.TestImportConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * date: 2021/7/1 16:05
 */
public class TestImport {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestImportConfiguration.class);
        Cat cat = ac.getBean(Cat.class);
        Dog dog = ac.getBean(Dog.class);
        //Dog dog = (Dog)ac.getBean("dog");
        //CatSelector catSelector = ac.getBean(CatSelector.class);
        cat.print();
        dog.print();
    }

}
