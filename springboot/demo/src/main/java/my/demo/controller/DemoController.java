package my.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu peng bo
 * @date 2023/11/30 16:57
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
