package my.concurrent.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liu peng bo
 * @date 2022/1/12 下午7:55
 */
public class ClhLock {
    private class Node {
        private String name;

        private boolean lock = false;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "name:" + name + ",lock:" + lock;
        }
    }

    private ThreadLocal<Node> current;
    private ThreadLocal<Node> pre;
    private AtomicReference<Node> tail;
    int i=1;

    public ClhLock() {
        current = ThreadLocal.withInitial(() -> new Node(String.valueOf(++i)));
        pre = new ThreadLocal<>();
        this.tail = new AtomicReference<>(new Node("1"));
    }

    public void lock() {
        current.get().lock = true;
        Node preNode = tail.getAndSet(current.get());
        pre.set(preNode);
        while (preNode.lock) {

        }
        System.out.println("current:"+current.get().toString() + ";prev:" + pre.get().toString());
    }

    public void unlock() {
        current.get().lock = false;
        current.set(pre.get());
    }


    public static void main(String[] args) throws InterruptedException {
        KFC kfc = new KFC();
        Executor executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 35; i++) {
            executor.execute(kfc::takeout);
        }
    }
}

class KFC {
    private final ClhLock lock = new ClhLock();
    private int i = 0;

    public void takeout() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": 拿了第" + ++i + "份外卖");
            //Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

