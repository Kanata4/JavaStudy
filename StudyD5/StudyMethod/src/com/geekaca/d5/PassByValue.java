package com.geekaca.d5;

public class PassByValue {
    public static void main(String[] args) {
        int number = 10;
        change(number);
        System.out.println(number);
    }

    public static void change(int a){
        //复制了 你传进来的参数的值
//        System.out.println(a);
        a = 20;
//        System.out.println(a);
    }
}
