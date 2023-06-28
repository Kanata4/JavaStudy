package com.geekaca.review628;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("黑龙江省");
        list1.add("浙江省");
        list1.add("江西省");
        list1.add("广东省");
        list1.add("福建省");
        List<String> list2 = new ArrayList<>();
        list2.add("哈尔滨");
        list2.add("杭州");
        list2.add("南昌");
        list2.add("广州");
        list2.add("福州");
        Map<String,String> cityMap = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            cityMap.put(list1.get(i),list2.get(i));
        }
        System.out.println(cityMap);
    }
}
