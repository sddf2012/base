package my.testimport;

import my.domain.Dog;
import org.springframework.context.annotation.Import;

/**
 * @author liu peng bo
 * date: 2021/7/1 16:08
 */
//@Import({Cat.class,Dog.class})
@Import(Dog.class)
@EnableCat(name = "12323")
public class TestImportConfiguration {
}
