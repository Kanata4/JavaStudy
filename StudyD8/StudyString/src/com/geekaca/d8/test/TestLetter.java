package com.geekaca.d8.test;

import java.util.Scanner;

public class TestLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.next();
        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                charCount++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numCount++;
            }
        }
        System.out.println("字母有：" + charCount + "个。数字有：" + numCount + "个");
    }
}
