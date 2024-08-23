package my.demo.service.utils;

import my.demo.domain.cnst.ChatConst;

/**
 * @author liu peng bo
 * @date 2024/08/19 16:44
 */
public class UniqueIdUtil {
    private static final long startTime = 1720000000000L;

    private static int seq = 100;


    public static synchronized String getUniqueId() {
        long time = System.currentTimeMillis() - startTime;
        return String.format("%d%03d", time, seq++);
    }

    public static void main(String[] args) {
        System.out.println(getUniqueId());
    }
}
