package my.base.reference;

import lombok.ToString;
import my.domain.Cat;

import java.lang.ref.*;

/**
 * @author liu peng bo
 * @date 2022/1/3 上午10:54
 */
@ToString
public class FourReference {
    public static void softReference() throws InterruptedException {
        ReferenceQueue<Cat> queue = new ReferenceQueue<>();
        SoftReference<Cat> softReference = new SoftReference<>(new Cat("tom", "male", 2), queue);
        System.gc();
        Thread.sleep(1000);
        System.out.println(softReference.isEnqueued());
    }

    public static void weakReference() throws InterruptedException {
        ReferenceQueue<Cat> queue = new ReferenceQueue<>();
        WeakReference<Cat> weakReference = new WeakReference<>(new Cat("jerry", "male", 2), queue);
        System.out.println(queue.poll());
        System.gc();
        Thread.sleep(1000);
        System.out.println(weakReference.isEnqueued());
        System.out.println(queue.poll());
    }

    public static void phantomReference() throws InterruptedException {
        ReferenceQueue<Cat> queue = new ReferenceQueue<>();
        PhantomReference<Cat> phantomReference = new PhantomReference<>(new Cat("jerry", "male", 2), queue);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
        System.gc();
        Thread.sleep(1000);
        System.out.println(phantomReference.isEnqueued());
        System.out.println(queue.poll());
    }

    public static void main(String[] args) throws InterruptedException {
        //softReference();
        //weakReference();
        phantomReference();
    }
}
