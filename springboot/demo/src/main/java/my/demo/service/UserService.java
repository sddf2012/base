package my.demo.service;

import my.demo.config.BusinessException;
import my.demo.domain.bo.LoginBo;
import my.demo.domain.entity.User;
import my.demo.domain.vo.LoginInfo;
import my.demo.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu peng bo
 * @date 2024/08/16 16:56
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public static ConcurrentHashMap<String, LoginInfo> tokenMap = new ConcurrentHashMap<>();

    public LoginInfo login(LoginBo bo) {
        User user = repository.findByPhone(bo.getPhone());
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        LoginInfo loginInfo = new LoginInfo();
        BeanUtils.copyProperties(user, loginInfo);
        loginInfo.setToken(token);
        loginInfo.setExpireTime(System.currentTimeMillis() + 86400000L);
        tokenMap.put(token, loginInfo);
        return loginInfo;
    }
}
