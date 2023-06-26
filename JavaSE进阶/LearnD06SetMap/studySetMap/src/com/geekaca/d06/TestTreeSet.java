package com.geekaca.d06;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 笔记：
 * Set 去除重复元素
 * TreeSet 可以排序
 */
public class TestTreeSet {
    public static void main(String[] args) {
        /**
         * Treeset
         * Set 去除重复
         * TreeSet又增加了自己的特征 自动排序
         */
        Set<Integer> scoresSet = new TreeSet<>();
        scoresSet.add(23);
        scoresSet.add(98);
        scoresSet.add(99);
        scoresSet.add(68);
        scoresSet.add(68);
        System.out.println(scoresSet);

        Set<String> set2 = new TreeSet<>();
        set2.add("Java");
        set2.add("alibaba");
        set2.add("Tomcat");
        set2.add("PHP");
        set2.add("AHP");
        System.out.println(set2);
        /**
         * 按自定义规则进行排序 （了解）
         */
        testComparator();
    }

    public static void testComparator(){
        //alt + enter 优化
        Set<Integer> set2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        set2.add(99);
        set2.add(19);
        set2.add(109);
        set2.add(89);
        System.out.println(set2);
    }
}
