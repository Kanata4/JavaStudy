package com.geekaca.d3homework;

import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = sc.nextInt();
        System.out.println("请输入第三个整数：");
        int count = sc.nextInt();
        switch (count) {
            case 1:
                System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
            case 2:
                System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
            case 3:
                System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
            case 4:
                System.out.println(num1 * 1.0 + "/" + num2 * 1.0 + "=" + (num1 * num2 * 1.0));
        }

    }
}
