package com.geekaca.d3homework;

import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存入金额：");
        double money = scanner.nextDouble();
        if (money < 1000) {
            System.out.println("输入金额错误");
        } else {
            System.out.println("请输入存入年限：");
            int year = scanner.nextInt();
            double benxi = 0;
//            switch (year) {
//                case 1:
//                    benxi = money + money * 1.0 * 0.0225;
//                    break;
//                case 2:
//                    benxi = money + money * 2.0 * 0.027;
//                    break;
//                case 3:
//                    benxi = money + money * 3.0 * 0.0325;
//                    break;
//                case 5:
//                    benxi = money + money * 5.0 * 0.036;
//                    break;
//            }
            if (year == 1) {
                benxi = money + money * 1.0 * 0.0225;
            } else if(year == 2){
                benxi = money + money * 2.0 * 0.027;
            } else if(year == 3){
                benxi = money + money * 3.0 * 0.0325;
            } else if(year == 5){
                benxi = money + money * 5.0 * 0.036;
            } else {
                System.out.println("输入年限错误");
            }
            System.out.println("本息总额为：" + benxi);
        }
    }
}
