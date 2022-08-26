package my.demo.config.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2022-7-28 13:54
 */
@Configuration
public class DynamicDatasourceConfig {
    @Bean
    public DynamicDatasource dynamicDatasource(DynamicDatasourceProperties properties){
           return null;
    }
}
