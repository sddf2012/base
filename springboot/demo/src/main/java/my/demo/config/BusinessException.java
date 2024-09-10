package my.demo.config;

/**
 * @author liu peng bo
 * @date 2024/08/22 9:50
 */
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
