package my.aop.service.impl;

import my.aop.service.TestService;
import my.aop.service.TestService2;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2021/3/26 14:32
 */
public class TestService2Impl implements TestService2 {

    private List<TestService> testServices;

    public void setTestServices(List<TestService> testServices) {
        this.testServices = testServices;
    }

    @Override
    public void test2() {
        System.out.println("test2");
        if (!CollectionUtils.isEmpty(testServices)) {
            testServices.forEach(TestService::test);
        }
    }


}
