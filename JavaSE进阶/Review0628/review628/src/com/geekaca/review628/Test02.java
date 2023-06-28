package com.geekaca.review628;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test02 {
    public static void main(String[] args) {
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("张三",800);
        m1.put("李五",1500);
        m1.put("王五",3000);

        m1.put("张三",2600);
        System.out.println(m1);

        for (String key : m1.keySet()){
            int oldValue = m1.get(key);
            int newValue = oldValue + 100;
            m1.replace(key,oldValue,newValue);
        }
        System.out.println(m1);

        //遍历 员工名字
        System.out.println("名字：");
        m1.forEach((key,value) -> {
            System.out.println(key + " ");
        });

        //遍历 工资
        System.out.println("工资：");
        for (String key : m1.keySet()){
            int value = m1.get(key);
            System.out.println(value + " ");
        }
    }
}
