package my.base.collection.list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liu peng bo
 * @date 2022-7-6 9:56
 */
public class ConcurrentModifyExceptionDemo {
   static ArrayList<Integer> list=new ArrayList<>();
    static {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    public static void main(String[] args) {
       // list1();
        System.out.println(String.join( ",",  new String[]{"1","2"}));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list);
        /*StringBuilder builder=new StringBuilder("123");
        builder.append(list);
        System.out.println(builder.toString());*/
    }
    public static void list1(){
        for (int i = 0; i < list.size(); i++) {
            //if(i==0)
            list.remove(i);
        }
        System.out.println(list);
    }
}
