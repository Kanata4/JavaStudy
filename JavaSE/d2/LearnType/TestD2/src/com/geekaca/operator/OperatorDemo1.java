package com.geekaca.operator;

public class OperatorDemo1 {
    public static void main(String[] args) {
        /**
         *  算术运算符
         */
        int num1 = 99;
        int num2 = 100;
        System.out.println(num1 + num2);
        System.out.println(num2 - num1);
        System.out.println(num1 * num2);
        System.out.println("===========");
        int a = 5;
        int b = 2;
        System.out.println(a / b);
        // 把a转变为小数， 再除法， 能够得到带有小数点的结果
        System.out.println(a * 1.0 / b);
        /**
         * 取余数
         */
        System.out.println(a % b);
        System.out.println("===========");
        int m = 102;
        int n = 10;
        System.out.println(m % n);
    }
}
