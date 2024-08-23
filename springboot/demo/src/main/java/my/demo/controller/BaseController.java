package my.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import my.demo.domain.vo.LoginInfo;
import my.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;


/**
 * @author liu peng bo
 * @date 2024/08/22 11:22
 */
public class BaseController {
    public LoginInfo getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return null;
        }
        return UserService.tokenMap.get(token);
    }
}
