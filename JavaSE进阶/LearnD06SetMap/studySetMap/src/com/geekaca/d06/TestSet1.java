package com.geekaca.d06;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ArrayList中存了10万个学生名字String 但是有重复的
 * 如何去除重复？
 */
public class TestSet1 {
    public static void main(String[] args) {
        /**
         * Set集合
         * 1.元素不重复(自动去除重复元素)
         * 2.无序
         * 3.无索引
         *
         * ！无序无索引 不重复
         */
        Set<String> sets = new HashSet<>();
        sets.add("Java");
        sets.add("Java");
        sets.add("Tomcat");
        sets.add("Jack");
        sets.add("Jack");
        sets.add("张三丰");
//        System.out.println(sets);
//        sets.forEach((item) ->{
//            System.out.println(item);
//        });
//
//        for (String item:sets){
//            System.out.println(item + " ");
//        }
        test();
    }

    public static void test(){
        Set<String> sets = new LinkedHashSet<>();
        sets.add("Java");
        sets.add("Java");
        sets.add("Tomcat");
        sets.add("Jack");
        sets.add("Jack");
        sets.add("张三丰");
        System.out.println(sets);
    }
}
