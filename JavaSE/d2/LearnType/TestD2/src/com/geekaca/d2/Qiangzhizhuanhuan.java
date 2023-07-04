package com.geekaca.d2;

public class Qiangzhizhuanhuan {
    public static void main(String[] args) {
        /**
         * 强制类型转换
         */
        // 底层原理： 涉及到 二进制补码
        int weixinSteps = 9999;

        // 强制类型转换 由较大范围数字 强制转换到小范围的变量
        byte bt = (byte) weixinSteps;
        System.out.println("bt:" + bt);
    }
}
