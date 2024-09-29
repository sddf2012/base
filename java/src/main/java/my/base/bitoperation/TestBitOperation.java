package my.base.bitoperation;

/**
 * @author liu peng bo
 * @date 2022/1/6 下午5:12
 */
public class TestBitOperation {
    public static void main(String[] args) {
        //System.out.println((1)&15);
        /*System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^0);
        System.out.println((int)(1<<16));*/
        /*System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()>>10);
        System.out.println(System.currentTimeMillis()>>10);*/
        /*System.out.println((-1)<<1);
        System.out.println((-1)<<29);
        System.out.println((1)<<29);
        System.out.println((2)<<29);
        System.out.println((3)<<29);*/
        base();

    }

    public static void base() {
        int a = 5;
        int b = -5;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

    public static void move() {
        int a = (-1) << 29;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println((-1) << 29);

    }
}
