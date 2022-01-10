package my.base.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2022/1/9 下午1:56
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {


        LinkedHashMap<String, String> accessOrderedMap = new LinkedHashMap<String, String>(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) { // 实现自定义删除策略，否则行为就和普遍Map没有区别
                return size() > 3;
            }
        };
        accessOrderedMap.put("Project1", "Valhalla");
        accessOrderedMap.put("Project2", "Panama");
        accessOrderedMap.put("Project3", "Loom");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 模拟访问
        accessOrderedMap.get("Project2");
        accessOrderedMap.get("Project1");
        accessOrderedMap.get("Project1");
        System.out.println("Iterate over should be not affected:");
        accessOrderedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        // 触发删除
        accessOrderedMap.put("Project4", "Mission Control");
        System.out.println("Oldest entry should be removed:");
        accessOrderedMap.forEach((k, v) -> {// 遍历顺序不变
            System.out.println(k + ":" + v);
        });
    }
}
