package com.geekaca.d07.test_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        /**
         * 了解
         * Stream API
         *          forEach : 逐一处理(遍历)
         *          count：统计个数
         *             -- long count();
         *          filter : 过滤元素
         *             -- Stream<T> filter(Predicate<? super T> predicate)
         *          limit : 取前几个元素
         *          skip : 跳过前几个
         *          map : 加工方法
         *          concat : 合并流。
         */
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        //统计个数
        long cnt = list.stream().filter(s -> s.length() == 3).count();
        System.out.println("名字三个字的有多少个：" + cnt);

        //查询名字开头是张的，但是只显示前两个
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);
        System.out.println("========姓名张 ，但不看第一个========");
        list.stream().filter(s -> s.startsWith("张")).skip(1).forEach(System.out::println);
        System.out.println("---------对元素进行加工---------");
        //对元素进行加工, 对原始集合无影响
        list.stream().map( s -> "极客咖的" + s).forEach(System.out::println);
        System.out.println(list);
        System.out.println("---利用名字逐一构造学生对象---");
        //遍历集合，利用名字逐一构造学生对象
        list.stream().map(s -> new Student(s)).forEach(stu -> System.out.println(stu));

        //流的合并
        System.out.println("====流的合并====");
        Stream<String> zhangStream = list.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = Stream.of("Java", "张三丰");
        Stream<String> sResult = Stream.concat(zhangStream, s2);
//        sResult.forEach(s -> System.out.println(s));
        System.out.println("###############去除重复###############");
        sResult.distinct().forEach(s-> System.out.println(s));
    }
}
