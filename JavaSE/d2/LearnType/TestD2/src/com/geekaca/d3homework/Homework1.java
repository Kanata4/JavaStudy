package com.geekaca.d3homework;

public class Homework1 {
    public static void main(String[] args) {
        boolean isKongtiaoOk = false;
        boolean isWifiOk = true;
        boolean isEat1 = isKongtiaoOk && isWifiOk;
        System.out.println("---------短路与&&----------");
        System.out.println("ここで食べますか：" + isEat1);
        boolean isEat2 = isKongtiaoOk || isWifiOk;
        System.out.println("---------短路或||----------");
        System.out.println("ここで食べますか：" + isEat2);

    }
}
