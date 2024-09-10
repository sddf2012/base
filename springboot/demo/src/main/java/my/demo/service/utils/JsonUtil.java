package my.demo.service.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.demo.config.BusinessException;

/**
 * @author liu peng bo
 * @date 2024/09/03 16:52
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new BusinessException("json convert error");
        }
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new BusinessException("json parse error");
        }
    }
}
