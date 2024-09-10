package my.demo.controller;

import my.demo.config.CommonVo;
import my.demo.domain.bo.LoginBo;
import my.demo.domain.vo.LoginInfo;
import my.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu peng bo
 * @date 2024/08/16 16:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonVo<LoginInfo> login(@RequestBody LoginBo loginBo) {
        return CommonVo.success(userService.login(loginBo));
    }


}
