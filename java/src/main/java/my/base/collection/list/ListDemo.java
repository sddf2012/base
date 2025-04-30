package my.base.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/11/01 9:11
 */
public class ListDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(0,0);
        System.out.println(list);
    }
}
