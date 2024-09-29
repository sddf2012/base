package my.concurrent.volatileTest;

public class VolatileVisibilityExample {
    private volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileVisibilityExample example = new VolatileVisibilityExample();
        new Thread(() -> {
            while (!example.flag) {
                // 等待 flag 变为 true
            }
            System.out.println("Flag is true.");
        }).start();

        Thread.sleep(1000);
        example.flag = true;
    }
}
