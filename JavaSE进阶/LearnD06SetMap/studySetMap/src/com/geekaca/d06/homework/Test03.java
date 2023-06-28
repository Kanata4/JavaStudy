package com.geekaca.d06.homework;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        /**
         * 统计景点的投票数
         * 每个人可以选多个景点
         * 1.如何收集大家的投票
         * 日常生活中 每人上交一个纸条 上面写着自己的选择 多选
         * Tom{BC}
         * Jack {ACD}
         * 张三丰{D}
         * Set 去除重复
         * 2.如何统计票数高低
         *
         * 用一个集合保存所有人的选择
         * List 允许重复
         */
        List<String> lastList = new ArrayList<>();
        Set<String> zhangsanSet = new HashSet<>();
        Collections.addAll(zhangsanSet, "D", "D", "D", "D");
        Set<String> tomSet = new HashSet<>();
        Collections.addAll(tomSet, "B", "C");
        Set<String> jackSet = new HashSet<>();
        Collections.addAll(jackSet, "A", "C", "D");
        Set<String> zhangsanfengSet = new HashSet<>();
        Collections.addAll(zhangsanfengSet, "C");
        //把另一个集合的所有元素  加入到lastList中
        lastList.addAll(zhangsanSet);
        lastList.addAll(tomSet);
        lastList.addAll(jackSet);
        lastList.addAll(zhangsanfengSet);
        System.out.println(lastList);
        Map<String, Integer> countMap = new HashMap<>();
        //统计各个字母的 数量
        lastList.forEach((item) -> {
            Integer cnt = countMap.get(item);
            if (cnt == null) {
                countMap.put(item, 1);
            } else {
                countMap.put(item, cnt + 1);
            }
        });
        System.out.println("投票统计：" + countMap);
    }
}
