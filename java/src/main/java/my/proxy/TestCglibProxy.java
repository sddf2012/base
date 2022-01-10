package my.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author liu peng bo
 * @date 2022/1/4 下午4:28
 */
public class TestCglibProxy {
    /**
     * 设置保存Cglib代理生成的类文件。
     *
     * @param dir 保存文件路径
     */
    public static void saveGeneratedCGlibProxyFiles(String dir) {
        try {
            Field field = System.class.getDeclaredField("props");
            field.setAccessible(true);
            Properties props = (Properties) field.get(null);
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
            props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        saveGeneratedCGlibProxyFiles("com.cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FoodImpl.class);
        enhancer.setCallback(new FoodMethodInterceptor());
        Food food = (Food) enhancer.create();
        food.info("香蕉");
    }
}

class FoodMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib before!");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("cglib after!");
        return object;
    }
}
