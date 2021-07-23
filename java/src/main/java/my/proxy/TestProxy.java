package my.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liu peng bo
 * date: 2021/7/21 15:51
 */
public class TestProxy {
    public static void main(String[] args) {
        Food food = (Food) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{Food.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("香蕉");
                return null;
            }
        });
        food.info();

    }
}
