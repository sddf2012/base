package my.concurrent.volatileTest;

public class VolatileReorderingExample {
    private int x = 0;
    private volatile boolean flag = false;

    public void writer() {
        x = 42;
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileReorderingExample example = new VolatileReorderingExample();
        new Thread(example::writer).start();
        new Thread(example::reader).start();
        Thread.sleep(1000);
    }
}
