package com.geekaca.d3homework;

import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("普通顾客输入0，会员输入1：");
        int isHuiyuan = scanner.nextInt();
        if(isHuiyuan == 0) {
            System.out.println("请输入消费的金额：");
            int costMoney1 = scanner.nextInt();
            if (costMoney1 < 100 && costMoney1 > 0) {
                System.out.println("您需要支付：" + costMoney1);
            } else if (costMoney1 >= 100){
                double costMoney2 = costMoney1 * 0.9;
                System.out.println("您需要支付" + costMoney2);
            } else {
                System.out.println("金额输入错误");
            }
        } else if(isHuiyuan == 1){
            System.out.println("请输入消费的金额：");
            int costMoney1 = scanner.nextInt();
            if (costMoney1 < 200 && costMoney1 > 0) {
                double costMoney2 = costMoney1 * 0.8;
                System.out.println("您需要支付：" + costMoney2);
            } else if (costMoney1 >= 200){
                double costMoney2 = costMoney1 * 0.75;
                System.out.println("您需要支付" + costMoney2);
            } else {
                System.out.println("金额输入错误");
            }
        }
    }
}
