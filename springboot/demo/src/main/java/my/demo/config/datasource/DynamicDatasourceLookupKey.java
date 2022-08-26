package my.demo.config.datasource;

/**
 * @author liu peng bo
 * @date 2022-7-27 17:23
 */
public class DynamicDatasourceLookupKey {
    private static final ThreadLocal<String> dsKey = new ThreadLocal<>();

    public static void set(String key) {
        dsKey.set(key);
    }

    public static String get() {
        return dsKey.get();
    }

    public static void remove() {
        dsKey.remove();
    }

}
