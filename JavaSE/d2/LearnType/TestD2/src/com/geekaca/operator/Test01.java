package com.geekaca.operator;

public class Test01 {
    public static void main(String[] args) {
        int num1 = 320;
        int num2 = num1 % 10;
        int num3 = num1 / 10 % 10;
        int num4 = num1 / 10 / 10 % 10;
        System.out.println("整数" + num1 + "的个位是" + num2);
        System.out.println("整数" + num1 + "的十位是" + num3);
        System.out.println("整数" + num1 + "的百位是" + num4);
    }
}
