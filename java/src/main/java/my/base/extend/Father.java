package my.base.extend;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2024/09/14 15:05
 */
@Data
public class Father {
    private String name;

    public Father() {
        System.out.println("father");
    }

    public Father(String name) {
        System.out.println("father name");
        this.name = name;
    }
}
