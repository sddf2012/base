package my.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author liu peng bo
 * @date 2024/09/02 17:04
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}
