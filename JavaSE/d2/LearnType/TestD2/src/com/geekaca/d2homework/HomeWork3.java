package com.geekaca.d2homework;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //追求写代码尽量不摸鼠标
        System.out.println("请输入用户年龄：");
        int age = scanner.nextInt();
        if (age > 18) {
            System.out.println("成年");
        } else {
            System.out.println("未成年");
        }
    }
}
