package com.geekaca.d4;

public class ArrayDynamic {
    public static void main(String[] args) {
        /**
         * 动态初始化
         */
        int[] ages = new int[3];
        ages[0] = 23;
        ages[1] = 22;

        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

        double[] moneys = new double[4];
        for (int i = 0; i < moneys.length; i++) {
            System.out.println(moneys[i]);
        }
        boolean[] okArr = new boolean[3];
        for (int i = 0; i < okArr.length; i++) {
            System.out.println(okArr[i]);
        }

        String[] names = new String[3];
        //null 引用类型默认值 一个钥匙号牌 但是没有号码 不指向任何地方
        System.out.println(names[0]);
        //不能混用
//        int[] arr = new int[3]{12,23,3};
    }
}
