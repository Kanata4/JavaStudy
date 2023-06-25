package com.geekaca.d05;

import java.util.LinkedList;

public class HelloLinkedList {
    public static void main(String[] args) {
        /**
         * 链表
         * 单列集合
         *
         * 掌握特点：国内的面试比较喜欢问
         * LinkedList 底层链表结构 适用场景： 需要频繁的对集合的元素进行修改（替换），删除
         * 性能很高
         *
         * ArrayList  底层 队列 ，有索引，适用场景： 向队尾增加元素，利用索引快速定位元素，查找
         *
         * 面试技巧： 讲项目时候，捎带把你知道的知识点show一下
         */
        LinkedList<String> list = new LinkedList();
        list.add("Tom");
        list.add("Jack");
        list.add("Jerry");
        for(String item : list){
            System.out.println(item);
        }
    }
}
