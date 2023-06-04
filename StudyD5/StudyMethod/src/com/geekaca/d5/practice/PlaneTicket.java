package com.geekaca.d5.practice;

import java.util.Scanner;

public class PlaneTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入机票原价，月份和舱（头等舱/经济舱）");
        double price = input.nextDouble();
        int month = input.nextInt();
        int cabin = input.nextInt();
        System.out.println(buyPlaneTicket(price,month,cabin));
    }

    public static double buyPlaneTicket(double price, double month, int cabin){
        if (month >= 5 && month <= 10){
            switch (cabin){
                case 1:
                    price = price * 0.9;
                    break;
                case 2:
                    price = price * 0.85;
                    break;
            }
        } else if (month >= 1 && month <= 12){
            switch (cabin){
                case 1:
                    price = price * 0.7;
                    break;
                case 2:
                    price = price * 0.65;
                    break;
            }
        } else {
            System.out.println("月份输入错误");
        }
        return price;
    }
}
