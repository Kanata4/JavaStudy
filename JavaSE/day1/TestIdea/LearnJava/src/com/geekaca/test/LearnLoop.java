package com.geekaca.test;

public class LearnLoop {
    public static void main(String[] args) {
        // 底下是耗费的时间 1秒 second = 1000毫秒 millisecond
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 100000; i++){
            System.out.println("i:" + i);
        }
        int j = 10;
        boolean isBigger = j >= 10;
        System.out.println("isBigger" +  isBigger);
        // 底下是耗费的时间 1秒 second = 1000毫秒 millisecond
        System.out.println(System.currentTimeMillis() - start);

    }
}
