package com.geekaca.d3homework;

public class Homework2 {
    public static void main(String[] args) {
        /**
         * 比较三个数谁最大,输出最大值
         */
        int num1 = 30;
        int num2 = 45;
        int num3 = 19;
        int temp = num1 > num2 ? num1 : num2;
        System.out.println(num3 > temp ? num3 : temp);
    }
}
