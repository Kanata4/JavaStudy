package com.geekaca.d3homework;

public class Homework3 {
    public static void main(String[] args) {
        double fatherHeight = 177.0;
        double motherHeight = 165.0;
        double sonHeight = (fatherHeight + motherHeight) * 1.08 / 2.0;
        double daughterHeight = (fatherHeight * 0.923 + motherHeight) / 2.0;
        // 保留小数点后2位
        String result = String.format("%.2f",daughterHeight);
        System.out.println("儿子的身高为：" + sonHeight);
        System.out.println("女儿的身高为：" + daughterHeight);
        System.out.println(result);
    }
}
