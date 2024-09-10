package my.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liu peng bo
 * @date 2024/08/26 11:31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public CommonVo<String> handleException(BusinessException e) {
        return CommonVo.fail(e.getMessage(), null);
    }
}
