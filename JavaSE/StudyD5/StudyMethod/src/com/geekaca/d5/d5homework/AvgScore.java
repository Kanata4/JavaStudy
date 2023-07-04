package com.geekaca.d5.d5homework;

public class AvgScore {
    public static void main(String[] args) {
        int[] scores = {72,89,65};
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        System.out.println("总成绩：" + total);
        System.out.println("平均分：" + total*1.0/scores.length);
    }
}
