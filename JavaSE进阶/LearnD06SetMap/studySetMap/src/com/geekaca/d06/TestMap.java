package com.geekaca.d06;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        /**
         * Map
         */
        Map<String,String> map = new HashMap<>();
        map.put("T001","张无忌");
        map.put("T002","周芷若");
        map.put("T003","Tom");
        map.put("T004","Tom");
        //值可以重复
//        map.put(45,"Jack")
        String t001V = map.get("T001");
        System.out.println("key:T001 对应的值" + t001V);
        map.put(null,null);
        //相同的key 再次设置会覆盖之前的
        map.put("T001","张三丰");

        System.out.println(map.get("key:T001 对应的值" + map.get("T001")));

        //取一个不存在的key 没有就返回null
        System.out.println(map.get("T99"));
        //map 元素无顺序的
        System.out.println(map);
    }

    public static void testAPI(){
        Map<String,String> map = new HashMap<>();
        map.put("T001","张无忌");
        map.put("T002","周芷若");
        map.put("T003","Tom");

        System.out.println("是否包含key: T002" + map.containsKey("T002"));
        System.out.println("是否包含值: 周芷若" + map.containsValue("周芷若"));
        System.out.println("是否包含值: 芷若" + map.containsValue("周芷若"));
    }
}
