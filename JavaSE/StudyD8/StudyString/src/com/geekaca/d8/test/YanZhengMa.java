package com.geekaca.d8.test;

import java.util.Random;

public class YanZhengMa {
    public static void main(String[] args) {
        String strAll = "ABCDEFGHIJKLMNOPORSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        //循环五次
        String yzm = "";
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(strAll.length());
            char zifu = strAll.charAt(index);
            yzm += zifu;
        }
        System.out.println("验证码为" + yzm);
    }
}
