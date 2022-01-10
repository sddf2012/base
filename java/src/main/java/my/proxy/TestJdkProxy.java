package my.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class FoodInvocationHandler implements InvocationHandler {
    private Food target;

    public FoodInvocationHandler(Food target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis()+" 调用方法："+method.getName());
        return method.invoke(target,args);
    }
}

/**
 * @author liu peng bo
 * date: 2021/7/21 15:51
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Food food = (Food) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(), new Class[]{Food.class}, new FoodInvocationHandler(new FoodImpl()));
        food.info("苹果");
        food.price(1);
    }
}
