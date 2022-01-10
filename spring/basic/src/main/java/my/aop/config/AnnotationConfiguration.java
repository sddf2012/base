package my.aop.config;

import my.aop.service.TestService;
import my.aop.service.TestService2;
import my.aop.service.impl.TestService2Impl;
import my.aop.service.impl.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/6/2 14:58
 */
@Configuration
@ComponentScan("my.aop")
public class AnnotationConfiguration {
    @Bean
    public TestService testService() {
        return new TestServiceImpl(1);
    }

    @Bean
    public TestService testService1() {
        return new TestServiceImpl(2);
    }

    @Bean
    public TestService2 testService2(List<TestService> list) {
        TestService2Impl testService2 = new TestService2Impl();
        testService2.setTestServices(list);
        return testService2;
    }

}
