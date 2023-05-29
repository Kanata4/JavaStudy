package com.geekaca.testwhile;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        /*
         * 学习Random
         *
         * 不是从零开始的随机数
         * 30-100随机数
         * 减加法
         */

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            // 生成一个随机数 范围 [包含起点 包含0 [0，n) )不包含
            int rand = random.nextInt(10);
            System.out.println(rand);
        }
        // 生成30-100随机数
        /*
         * 1. 减法 100-30 = 70
         * 2， 30 + random(70)
         * 减加法
         */
        Random random = new Random();
        int rand30 = 30 + random.nextInt(70);
        System.out.println(rand30);
    }
}
