package com.geekaca.d4;

import java.util.Arrays;
import java.util.Random;

public class Homework1 {
    public static void main(String[] args) {
        /**
         * 随机打乱用户姓名
         */
        String[] names = {"Tom","Bill","Jack","Mark","Chovy"};
        Random random = new Random();
        System.out.println(Arrays.toString(names));
        for (int i = 0; i < names.length; i++) {
            //随机一个索引
            int index = random.nextInt(names.length);
            //数组元素交换值
            String temp = names[index];
            names[index] = names[i];
            names[i] = temp;
            }
        System.out.println(Arrays.toString(names));
        }
    }
