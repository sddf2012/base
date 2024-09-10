package my.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

/**
 * @author liu peng bo
 * @date 2023/11/30 16:57
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/longPolling")
    public DeferredResult<String> longPolling() {
        log.info("longPolling req!");
        DeferredResult<String> result = new DeferredResult<>();

        /*Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                result.setResult("success " + Thread.currentThread().getName());
            } catch (Exception e) {
                result.setErrorResult("error");
            }
        });
        log.info(thread.getName() + " start!");
        thread.start();*/

        try {
            Thread.sleep(5000);
            result.setResult("success " + Thread.currentThread().getName());
        } catch (Exception e) {
            result.setErrorResult("error");
        }
        return result;
    }
}
