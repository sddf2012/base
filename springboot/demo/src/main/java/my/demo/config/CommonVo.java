package my.demo.config;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author liu peng bo
 * @date 2024/08/26 11:14
 */
@Data
public class CommonVo<T> {
    private String code;

    private String message;

    private T data;

    public static <T> CommonVo<T> success(T data) {
        CommonVo<T> vo = new CommonVo<>();
        vo.setCode("0");
        vo.setData(data);
        return vo;
    }

    public static <T> CommonVo<T> fail(String message, T data) {
        CommonVo<T> vo = new CommonVo<>();
        vo.setCode("1");
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }
}
