package my.testimport;

import my.domain.Cat;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liu peng bo
 * date: 2021/7/1 16:39
 */
public class CatSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Cat.class.getName()};
    }
}
