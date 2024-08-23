package my.demo.domain.vo;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2024/08/19 16:33
 */
@Data
public class LoginInfo {
    private String id;

    private String phone;

    private String name;

    private String token;

    private Long expireTime;
}
