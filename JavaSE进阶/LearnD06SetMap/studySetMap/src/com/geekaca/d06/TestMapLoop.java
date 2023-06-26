package com.geekaca.d06;

import java.util.HashMap;
import java.util.Map;

public class TestMapLoop {
    public static void main(String[] args) {
        /**
         * Map遍历之 先拿所有key 再循环
         */
        Map<String ,Integer>maps = new HashMap<>();
        //1.添加元素 无序 不重复 无索引
        maps.put("哇哈哈",30);
        maps.put("苹果",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);

        //先拿到所有的key 每个key对应着自己的value
//        Set<String> keySet = maps.keySet();
//        for (String key : keySet){
//            System.out.println(key + ";" + maps.get(key));
//        }
        testLoopLambda();

        Student stu = new Student("Tom","999");
        Map map2 = new HashMap();
        //较少
        map2.put(stu,"89898989");
        //笔记：最常用的就是用String 当作key Integer;
        /**
         * Hash 结构最大优势 能够快速的计算出 哈希值 整数 然后从Map中快速定位到 对应的元素
         * 使用场景：
         * 当想要快速的定位到某个元素 首选HashMap结构
         * 比如 我有10万个学生 每个学生都有唯一的学号(S125Z1265362341)
         * 如何快速定位查找某一个学生 根据学号？ 作业
         * ArrayList
         * 一个个比对学号
         *
         * 写程序比较耗时
         */
    }

    public static void testLoopLambda(){
        Map<String ,Integer> maps = new HashMap<>();
        //1.添加元素 无序 不重复 无索引
        maps.put("哇哈哈",30);
        maps.put("苹果",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        maps.forEach((k,v)->{
            System.out.println(k + ";" + v);
        });
    }
}
