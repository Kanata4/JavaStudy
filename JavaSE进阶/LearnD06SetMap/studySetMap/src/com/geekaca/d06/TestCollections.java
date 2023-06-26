package com.geekaca.d06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        /**
         * 集合工具类
         */
        List<String> names = new ArrayList<>();
//        names.add("张三");
//        names.add("Tom");
//        names.add("Jack");
//        names.add("Jerry");
        //可变参数   ，参数个数可变化
        Collections.addAll(names, "c楚留香","h胡铁花", "z张无忌","l陆小凤", "Test", "Java");
        System.out.println(names);
        //打乱顺序
        Collections.shuffle(names);
        System.out.println(names);
        //排序
        Collections.sort(names);
        System.out.println(names);

        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        System.out.println(names);
        testCompare();
    }

    public static void testCompare(){
        /**
         * 集合存储自定义类型的对象
         *
         * 然后 按照自定义的规则排序
         * 练习：按照价格 升序
         */
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("红富士", "红色", 9.9, 500));
        apples.add(new Apple("青苹果", "绿色", 15.9, 300));
        apples.add(new Apple("绿苹果", "青色", 29.9, 400));
        apples.add(new Apple("黄苹果", "黄色", 9.8, 500));
        //sort函数期望  传进来的集合 ，中的每个元素都是可比较的（实现了 Comparable口的）
        Collections.sort(apples);
        System.out.println(apples);
    }
}
