package com.geekaca.d05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloIterator {
    public static void main(String[] args) {
        /**
         * 遍历值迭代器 了解
         */
        List<String> nameList = new ArrayList<>();
        nameList.add("张三丰");
        nameList.add("张无忌");
        nameList.add("小昭");
        //迭代器
        Iterator<String> iterator = nameList.iterator();
        //当前迭代器指向的集合 还有更多元素 返回true
        while(iterator.hasNext()){
            //指向下一个元素
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
