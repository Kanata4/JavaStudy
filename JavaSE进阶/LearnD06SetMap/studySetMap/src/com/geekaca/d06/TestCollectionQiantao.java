package com.geekaca.d06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCollectionQiantao {
    public static void main(String[] args) {
        /**
         * 集合嵌套
         */
        Map<String,String> studentMap = new HashMap<>();
        studentMap.put("姓名","张三");
        studentMap.put("年龄","19");

        Map<String,String> studentMap2 = new HashMap<>();
        studentMap2.put("姓名","张2");
        studentMap2.put("年龄","12");
        //嵌套 把集合放入另一个集合
        List<Map> stuList = new ArrayList<>();
        stuList.add(studentMap);
        stuList.add(studentMap2);

        for (int i = 0; i < stuList.size(); i++) {
            Map map = stuList.get(i);
            System.out.println("姓名" + map.get("姓名") + "年龄：" + map.get("年龄"));
        }
    }

}
