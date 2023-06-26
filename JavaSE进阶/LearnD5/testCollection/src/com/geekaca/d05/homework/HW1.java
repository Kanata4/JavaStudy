package com.geekaca.d05.homework;

import java.util.ArrayList;

/**
 * guojianxiong
 */
public class HW1 {
    public static void main(String[] args) {
        //目的：从集合中找出多个元素并删除

        ArrayList<String> list = new ArrayList<>();
        list.add("极客咖");
        list.add("Java");
        list.add("JavaScript");
        list.add("周芷若");
        list.add("赵敏");
        list.add("素素");
        list.add("张无忌");
        list.add("张三丰");
        list.add("金毛狮王");
        System.out.println("删除前：" + list);

        // 把要删除的元素放入一个集合
        ArrayList<String> toRemove = new ArrayList<>();
        toRemove.add("Java");
        toRemove.add("素素");
        toRemove.add("张三丰");

        // 查找并删除指定元素
        for (int i = list.size() - 1; i >= 0; i--) {
            String str = list.get(i);
            //判断toRemove这个集合中是否包含 str
            if (toRemove.contains(str)) {
                list.remove(i);
            }
        }
        System.out.println("删除后：" + list);
    }
}
