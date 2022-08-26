package my.base.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liu peng bo
 * @date 2022-8-3 10:44
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set= map.keySet();
        map.put(1,1);
        map.put(2,2);

        System.out.println(set.size());

    }
}
