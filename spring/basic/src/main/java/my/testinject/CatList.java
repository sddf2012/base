package my.testinject;

import lombok.Data;
import my.domain.Cat;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2022/3/30 下午7:52
 */
@Data
public class CatList {
    private List<Cat> cats;

    public int size() {
        return cats == null ? 0 : cats.size();
    }
}
