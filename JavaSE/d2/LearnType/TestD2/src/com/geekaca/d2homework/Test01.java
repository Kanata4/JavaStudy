package com.geekaca.d2homework;

public class Test01 {
    public static void main(String[] args) {
        double screenSize = 4.95;
        double mem = 16;
    //现在找到的手机 是否符合几个条件的组合 and 并且
        boolean isFuhe = screenSize > 6.95 & mem > 8;
        System.out.println("是否符合条件" + isFuhe);
        /**
         * 屏幕尺寸大于6.95 或者内存大于8G，都符合我的要求
         */
        boolean isFuhe2 = screenSize > 6.95 | mem > 8;
        System.out.println(screenSize + " " + mem + "符合？" + isFuhe2);

        System.out.println(!true);
        System.out.println("==============掌握 短路与和或=========");

        double screenSz = 4.3;
        double memory = 16;
        // 屏幕是否大于6.95 ， 内存是否大于8G
        boolean isScreenOk = screenSz > 6.95;
        boolean isMemoryOk = memory > 8;
        System.out.println(isScreenOk && isMemoryOk);

    }
}
