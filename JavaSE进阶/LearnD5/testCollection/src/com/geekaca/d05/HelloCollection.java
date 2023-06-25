package com.geekaca.d05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HelloCollection {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Tom");
        list.add("Tom");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //判断集合是否为空 空 返回true
        System.out.println("isEmpty " + list.isEmpty());
        //清空集合的元素
        list.clear();
        System.out.println("isEmpty " + list.isEmpty());
        //判断集合中是否包含某个元素
        System.out.println("java有？" + list.contains("java"));
        System.out.println("Tom有？" + list.contains("Tom"));
        //如果有多个重复元素 默认删除前面的第一个
        boolean isRemoveOk = list.remove("Tom");
        //ArrayList是一个Collection类型的
        //多态体现
        Collection myCollection = new ArrayList();
        //常用
        List myList = new ArrayList();
        myList.add("Tom");
        myList.add("Jack");
        myList.add("Jerry");
        //一次性把一个集合的所有元素 加入另一个集合
        List yourList = new ArrayList();
        yourList.addAll(myList);
        System.out.println(yourList.size());

        //不允许基本类型
        List<Integer> list1 = new ArrayList<>();
    }
}
