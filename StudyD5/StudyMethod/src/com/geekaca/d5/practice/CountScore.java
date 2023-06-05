package com.geekaca.d5.practice;

import java.util.Scanner;

public class CountScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.println("请第" + (i + 1) + "位评委打分");
            scores[i] = scanner.nextInt();
            if (scores[i] >= 0 && scores[i] <= 100) {
                continue;
            } else {
                System.out.println("请输入0~100之间的整数！！");
                break;
            }
        }
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        double result = (sum - max - min) * 1.0 / (scores.length - 2);
        System.out.println("去掉最高分" + max + "，去掉最低分" + min + "，选手的得分为：" + result);
    }
}
