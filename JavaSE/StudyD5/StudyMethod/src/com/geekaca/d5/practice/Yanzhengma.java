package com.geekaca.d5.practice;

import java.util.Arrays;
import java.util.Random;

public class Yanzhengma {
    public static void main(String[] args) {
        String yzm = "";
        int weishu = 5;
        System.out.println("生成的验证码为：" + createYzm(weishu));
    }

    public static String createYzm(int weishu) {
        Random rand = new Random();
        String str = "";
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] letter1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] letter2 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < weishu; i++) {
            //随机生成5位验证码，可能是数字，大写字母，小写字母
            int select = rand.nextInt(3);
            switch (select) {
                case 0:
                    int randNum = rand.nextInt(10);
                    str += num[randNum];
                    break;
                case 1:
                    int randLetter1 = rand.nextInt(26);
                    str += letter1[randLetter1];
                    break;
                case 2:
                    int randLetter2 = rand.nextInt(26);
                    str += letter2[randLetter2];
                    break;
            }
        }
        return str;
    }
}
