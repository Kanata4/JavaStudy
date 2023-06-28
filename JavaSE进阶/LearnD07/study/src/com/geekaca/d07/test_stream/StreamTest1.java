package com.geekaca.d07.test_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {
        //stream 方式
        List<String> names = new ArrayList<>();

        Collections.addAll(names, "张三丰", "张无忌", "周芷若", "赵敏", "张强");
        names.stream().filter((item)->item.startsWith("张"))
        .filter(item -> item.length() == 3).forEach((item)-> System.out.println(item));
        //经过两次过滤，最终留下来的是符合两种条件的结果
    }
    public static void oldStyle(){
        List<String> names = new ArrayList<>();

        Collections.addAll(names, "张三丰", "张无忌", "周芷若", "赵敏", "张强");
        // 1、从集合中找出姓张的放到新集合
        List<String> zhangList = new ArrayList<>();
        for (String name : names) {
            /**
             * String是否以张开头
             */
            if(name.startsWith("张")){
                zhangList.add(name);
            }
        }
        // 2、张姓里找名称长度是3的姓名
        List<String> zhangThreeList = new ArrayList<>();
        //遍历 姓张的集合
        for (String name : zhangList) {
            if(name.length() == 3){
                zhangThreeList.add(name);
            }
        }
        System.out.println(zhangThreeList);
    }
}
