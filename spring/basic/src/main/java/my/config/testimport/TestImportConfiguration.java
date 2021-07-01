package my.config.testimport;

import org.springframework.context.annotation.Import;

/**
 * @author liu peng bo
 * date: 2021/7/1 16:08
 */
@Import({Cat.class,Dog.class})
public class TestImportConfiguration {
}
