package my.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import my.demo.config.BusinessException;
import my.demo.domain.vo.LoginInfo;
import my.demo.service.UserService;
import my.demo.service.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;


/**
 * @author liu peng bo
 * @date 2024/08/22 11:22
 */
public class BaseController {
    protected LoginInfo getCurrentUser(HttpServletRequest request, boolean checkNull) {
        String token = request.getHeader("token");
        LoginInfo loginInfo = null;
        if (!StringUtils.isBlank(token)) {
            loginInfo = JwtUtil.parseJwtToken(token);
        }
        if (checkNull && (loginInfo == null || loginInfo.getId() == null)) {
            throw new BusinessException("100", "未登录");
        }
        return loginInfo;
    }
}
