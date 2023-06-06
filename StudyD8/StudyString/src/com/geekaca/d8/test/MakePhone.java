package com.geekaca.d8.test;

import java.util.Scanner;

public class MakePhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号");
        String telString = sc.next();
        // 截取字符串前三位
        String start = telString.substring(0,3);
        // 截取字符串后四位
        String end = telString.substring(7);
        System.out.println(start + "****" + end);
    }
}
