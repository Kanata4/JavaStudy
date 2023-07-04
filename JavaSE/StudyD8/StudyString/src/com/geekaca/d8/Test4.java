package com.geekaca.d8;

public class Test4 {
    public static void main(String[] args) {
        // "abc"首先会到字符串常量池中判断，是否已经有了一个abc字符串

        //如果没有，则创建，并放入一个

        String s1 = "abc";
        //首先会去字符串常量池中找 有没有abc这个串，，有则拿来使用
        String s2 = "a" + "b" + "c";
        System.out.println(s1 == s2);
    }
}
