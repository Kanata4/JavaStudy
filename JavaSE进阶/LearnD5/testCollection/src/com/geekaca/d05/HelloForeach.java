package com.geekaca.d05;

import java.util.ArrayList;
import java.util.List;

public class HelloForeach {
    public static void main(String[] args) {
        /**
         * 增强for循环 foreach
         */
        List<String> nameList = new ArrayList<>();
        nameList.add("张三丰");
        nameList.add("张无忌");
        nameList.add("小昭");
        //name 只想集合中的每一个元素 注意类型
        //没有拿到索引，适合不需要索引的情况
        for (String name : nameList) {
            System.out.println(name);
            //修改无意义 不会影响数组的元素值
            name = "tesg";
        }
        System.out.println(nameList);
        }
    }

