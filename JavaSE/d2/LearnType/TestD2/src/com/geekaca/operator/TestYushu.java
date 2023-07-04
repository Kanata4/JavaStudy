package com.geekaca.operator;

public class TestYushu {
    public static void main(String[] args) {
        int num1 = 150;
        int gewei = num1 % 10;
        System.out.println(num1 + "的个位是：" + gewei);

        int shiwei = num1 / 10 % 10;
        System.out.println(num1 + "的个位是" + shiwei);

        int baiwei = num1 / 10 / 10 % 10;
        System.out.println(num1 + "的百位数是：" + baiwei);
    }
}
