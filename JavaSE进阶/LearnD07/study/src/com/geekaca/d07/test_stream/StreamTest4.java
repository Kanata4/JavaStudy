package com.geekaca.d07.test_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        /**
         * Stream 结果的收集
         */
        List<String> list = new ArrayList<>();
        list.add("张维");
        list.add("张维");
        list.add("张维2");
        list.add("张维3");
        list.add("周维");
        list.add("张维4");
        list.add("李伟");
        Stream<String> stream = list.stream().filter(s -> s.startsWith("张"));
        //结果放入List
        List<String> zhangList = stream.collect(Collectors.toList());
        System.out.println(zhangList);

        Stream<String> stream2 = list.stream().filter(s -> s.startsWith("张"));
        Set<String> nameSet = stream2.collect(Collectors.toSet());
        System.out.println(nameSet);

        Stream<String> stream3 = list.stream().filter(s -> s.startsWith("张"));
        Object[] objects = stream3.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
