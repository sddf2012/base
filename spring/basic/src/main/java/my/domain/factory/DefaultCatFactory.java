package my.domain.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liu peng bo
 * @date 2021/10/14 4:06 下午
 */
public class DefaultCatFactory implements CatFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 初始化中...");
    }

    public void customizedInit() {
        System.out.println("customInit 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("@DisposableBean 销毁中...");
    }

    public void customizedDestroy() {
        System.out.println("customizedDestroy 销毁中...");
    }
}
