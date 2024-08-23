package my.demo.config;

/**
 * @author liu peng bo
 * @date 2024/08/22 9:50
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
