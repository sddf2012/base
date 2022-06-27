package my.basicdemo;

import my.domain.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2021/10/14 11:20 上午
 */
@Configuration
@ComponentScan("my.basicdemo")
public class BasicDemoConfig {
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
