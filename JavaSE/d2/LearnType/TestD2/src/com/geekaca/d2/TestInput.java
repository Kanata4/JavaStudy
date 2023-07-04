package com.geekaca.d2;

import java.util.Scanner;

public class TestInput {
    /**
     * 学习 如果接收键盘输入
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        //使用它提供的函数（工具）
        //等待用户的输入
        String next = scanner.next();
        System.out.println("您输入了：" + next);
        System.out.println("请输入年龄：" );
        scanner.nextInt();
        System.out.println("您消费了:");
    }

}
