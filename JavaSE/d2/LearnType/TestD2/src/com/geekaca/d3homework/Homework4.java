package com.geekaca.d3homework;

public class Homework4 {
    public static void main(String[] args) {
        /**
         * 红茶妹妹：21元钱， 两倍还多三块
         * 绿茶妹妹：24元钱， 两倍
         */
        double redMoney = 21 * 2 + 3;
        double greenMoney = 24 * 2;
        boolean isSame = redMoney == greenMoney ? true : false;
        System.out.println("红茶和绿茶现在的钱一样多吗：" + isSame);
    }
}
