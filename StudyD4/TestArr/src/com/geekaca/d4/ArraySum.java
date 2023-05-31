package com.geekaca.d4;

public class ArraySum {
    public static void main(String[] args) {
        /**
         * 销售额求和
         */
        int[] sales = {12,23,45,66,88};
        //总额
        int totalSale = 0;
        for (int i = 0; i < sales.length; i++) {
//            totalSale = totalSale + sales[i];
            totalSale += sales[i];
        }
        System.out.println("总销售额：" + totalSale);

    }
}
