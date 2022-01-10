package my.aop.service.impl;

import my.aop.service.TestService;

/**
 * @author liu peng bo
 * date: 2021/3/26 14:31
 */
public class TestServiceImpl implements TestService {
    private int i;

    public TestServiceImpl() {
    }

    public TestServiceImpl(int i) {
        this.i = i;
    }

    @Override
    public void test() {
        System.out.println("test:" + i);
    }
}
