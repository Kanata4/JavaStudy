package com.geekaca.d3homework;

import java.util.Scanner;

public class homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = scanner.nextInt();
        System.out.println("请输入第三个整数：");
        int num3 = scanner.nextInt();
        int temp = num1 < num2 ? num1 : num2;
        int min = num3 < temp ? num3 : temp;
        System.out.println("最小值：" + min);
    }
}
