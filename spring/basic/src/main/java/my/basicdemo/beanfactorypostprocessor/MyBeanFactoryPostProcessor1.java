package my.basicdemo.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2022/5/1 下午5:28
 */
@Component
public class MyBeanFactoryPostProcessor1 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("--------------MyBeanFactoryPostProcessor1----------------");
    }
}
