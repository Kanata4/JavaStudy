package com.geekaca.d2homework;

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        double costMoney = scanner.nextDouble();
        if (costMoney > 1000) {
            costMoney = costMoney * 0.8;
            System.out.println("您需要支付" + costMoney);
        } else {
            System.out.println("您需要支付" + costMoney);
        }
    }
}
