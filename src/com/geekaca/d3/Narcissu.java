package com.geekaca.d3;

public class Narcissu {
    public static void main(String[] args) {
        // 保存水仙花的数量
        int narcissuCount = 0;
        for (int i = 100; i < 999; i++) {
            int gewei = i % 10;
//            System.out.println(i + "的个位是：" + gewei);
            int shiwei = i / 10 % 10;
//            System.out.println(i + "的个位是" + shiwei);
            int baiwei = i / 10 / 10 % 10;
//            System.out.println(i + "的百位数是：" + baiwei);
            int sum = gewei * gewei * gewei + shiwei * shiwei * shiwei + baiwei * baiwei * baiwei;
            if (i == sum) {
                System.out.println("水仙花数为" + i);
                narcissuCount++;
            }
        }
        System.out.println(narcissuCount);
    }
}
