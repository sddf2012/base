package my.demo.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper;
import com.zaxxer.hikari.HikariConfig;
import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2022-7-27 17:26
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "datasource.dynamic")
public class DynamicDatasourceProperties {
    private String defaultDs;

    private Map<String, HikariConfig> hikari;

    private Map<String, DruidDataSourceWrapper> druid;
}
