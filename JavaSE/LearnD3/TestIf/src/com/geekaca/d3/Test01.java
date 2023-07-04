package com.geekaca.d3;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        //alt + enter
        double score = scanner.nextDouble();
        if (score >= 0 && score < 80) {
            System.out.println("打屁股");
        } else if (score >= 80 && score < 90) {
            System.out.println("奖励变形金刚");
        } else if (score >= 90 && score < 95) {
            System.out.println("奖励去游乐园玩");
        } else if (score >= 95 && score <= 100) {
            System.out.println("奖励一辆自行车");
        } else {
            System.out.println("输入成绩错误");
        }
    }
}
