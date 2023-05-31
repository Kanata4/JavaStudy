package com.geekaca.d4;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        /**
         * 打乱顺序
         * 1.遍历
         * 随机取索引，把当前元素，和随机生成的索引位置交换
         */
        int[] employeeNos = {21,22,33,12,9};
        String[] names = {"Tom","Bill"};
        //[I@4eec7777 对象的地址
        System.out.println(Arrays.toString(employeeNos));
        Random random = new Random();
        for (int i = 0; i < employeeNos.length; i++) {
//            employeeNos[i]; 当前的元素
            //随机一个索引 范围 0~4 索引范围内
            int index = random.nextInt(employeeNos.length);
            //数组元素交换值
            int tmp = employeeNos[i];
            employeeNos[i] = employeeNos[index];
            employeeNos[index] = tmp;
        }
        System.out.println(Arrays.toString(employeeNos));

        /**
         * 变量交换值
         */
        int kele = 99;
        int qixi = 55;
        System.out.println("kele: " + kele + " qixi: " + qixi);
        int tmp = 0;
        tmp = kele;
        kele = qixi;
        qixi = tmp;
        System.out.println("kele: " + kele + " qixi: " + qixi);
    }
}
