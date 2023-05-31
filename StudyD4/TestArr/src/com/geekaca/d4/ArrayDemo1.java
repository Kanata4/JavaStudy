package com.geekaca.d4;

public class ArrayDemo1 {
    public static void main(String[] args) {
        /**
         * 数组定义
         * 静态初始化
         */
        double[] scores = new double[]{89.9,99.5,59.5,88,0};

        int[] myCounts = new int[]{23,45,56,34};
        //简写
        int[] numbers = {1,2,45,23,5};
        //地址
        int[] ages = {18,23,33,43};

        //访问元素 索引（下标）从0开始
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
        System.out.println(ages[3]);

        System.out.println(ages.length);

        for (int i = 0; i < ages.length; i++) {
            System.out.println(i + " " + ages[i]);
        }
        ages[1] = 99;
        for (int i = 0; i < ages.length; i++) {
            System.out.println(i + " " + ages[i]);
        }
        ages[1] = 99;
        for (int i = 0;i < ages.length;i++) {
            System.out.println(" " + ages[i] + " ");
        }
        System.out.println("数组最后一个元素：" + ages[ages.length - 1]);
    }
}
