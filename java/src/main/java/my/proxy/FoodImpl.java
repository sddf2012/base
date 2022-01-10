package my.proxy;

/**
 * @author liu peng bo
 * @date 2022/1/4 下午4:26
 */
public class FoodImpl implements Food{
    @Override
    public void info(String name) {
        System.out.println(name);
    }

    @Override
    public void price(int num) {
        System.out.println(100 * num);
    }
}
