package my.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * @author liu peng bo
 * date: 2021/6/23 14:26
 */
public class MyThreadFactory implements ThreadFactory {
    private String namePrefix;

    private int i = 0;

    public MyThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        i++;
        return new Thread(r, namePrefix + "-" + i);
    }
}
