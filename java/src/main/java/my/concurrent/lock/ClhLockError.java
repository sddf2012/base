package my.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liu peng bo
 * @date 2022/1/12 下午5:14
 */
public class ClhLockError {
    class Node {
        private String name;

        private Node prev;

        private Node next;

        private boolean isLock = true;

        public Node(String name) {
            this.name = name;
        }

        private boolean canLock() {
            return prev == null || !prev.isLock;
        }

        private boolean lock() {
            //System.out.println(name + " lock value before:" + lock.get());
            isLock = lock.compareAndSet(0, 1);
            //System.out.println(name + " lock value after:" + lock.get());
            return isLock;
        }

        private void unLock() {
            isLock = !lock.compareAndSet(1, 0);
        }

        @Override
        public String toString() {
            return name + ",prev:" + (prev == null ? "null" : prev.name) + ",next:" + (next == null ? "null" : next.name);
        }
    }

    private AtomicInteger lock = new AtomicInteger(0);

    private AtomicReference<Node> tailReference = new AtomicReference<>();

    private ThreadLocal<Node> threadLocal = new ThreadLocal<>();

    private Node head;
    private volatile Node tail = null;

    public void lock() {
        String name = Thread.currentThread().getName();
        Node current = new Node(name);
        threadLocal.set(current);
        for (; ; ) {
            Node t = tail;
            if (tailReference.compareAndSet(t, current)) {
                System.out.println(name + "添加至队尾!");
                if (tail == null) {
                    head = current;
                    tail = current;
                } else {
                    tail.next = current;
                    current.prev = tail;
                    tail = current;
                }
                break;
            }
        }
        for (; ; ) {
            if (current.canLock()) {
                current.lock();
                break;
            }
        }

    }

    public void unlock() {
        Node node = threadLocal.get();
        node.unLock();
        //System.out.println(node.name + " 释放了锁!" + lock.get());
        threadLocal.remove();
        //node = null;
    }

    public void allNodes() {

        StringBuilder builder = new StringBuilder();
        Node t = head;
        while (t != null) {
            builder.append(t.toString()).append("-->").append("\n");
            t = t.next;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        ClhLockError clhLock = new ClhLockError();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        clhLock.lock();
                        System.out.println(Thread.currentThread().getName() + "获取了锁!");
                    } finally {
                        clhLock.unlock();
                        //System.out.println(Thread.currentThread().getName() + "释放了锁!");

                    }
                }
            });
            thread.start();
        }
        Thread.sleep(2000);
        clhLock.allNodes();

    }

}
