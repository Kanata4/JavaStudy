package com.geekaca.d05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HelloLambdaFor {
    public static void main(String[] args) {
        /**
         * Lambda表达式
         * 最优雅
         */
        List<String> nameList = new ArrayList<>();
        nameList.add("张三丰");
        nameList.add("张无忌");
        nameList.add("小昭");
        //简洁写法
        nameList.forEach((name)->{
            //函数体
            if (name.length() >= 3){
                System.out.println(name);
            }
        });
        //最简洁 但只是和 只有一行代码的情况
        nameList.forEach((name)-> System.out.println(name));
        System.out.println("==========");
        //完整写法 匿名内部类 就地实现
        nameList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                //参数就是指向集合中的每一个元素
                System.out.println(s);
            }
        });
    }
}
