package com.geekaca.d3homework;

public class homework1 {
    public static void main(String[] args) {
        double newPhonePrice = 7988;
        double oldPhonePrice = 1500;
        double costMoney1 = newPhonePrice - oldPhonePrice;
        double costMoney2 = newPhonePrice * 0.8;
        if (costMoney1 > costMoney2) {
            System.out.println("李雷要以旧换新");
        } else {
            System.out.println("李雷不要以旧换新");
        }
    }
}
