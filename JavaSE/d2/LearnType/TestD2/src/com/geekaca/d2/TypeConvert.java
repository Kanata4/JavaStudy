package com.geekaca.d2;

public class TypeConvert {
    public static void main(String[] args) {
        /**
         * 自动类型转换
         *
         * byte：占一个字节 一个格子 刷牙桶
         * int：4个字节 四个格子 电脑 占四个格子
         */
        byte bt = 12;
        int length = bt;
        System.out.println("length:" + length);
        // 表达式 结果仍然是int
        double result = 12 + 13;
        System.out.println("result:" + result);
    }
}
