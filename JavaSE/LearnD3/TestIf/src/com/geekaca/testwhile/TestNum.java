package com.geekaca.testwhile;

import java.util.Random;
import java.util.Scanner;

public class TestNum {
    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int time = 0;
        while(time < 4) {
            System.out.println("请输入您猜的数字：");
            int guessNum = scanner.nextInt();
            if (guessNum > rand) {
                System.out.println("过大");
            } else if (guessNum < rand){
                System.out.println("过小");
            } else {
                System.out.println("猜对了");
                break;
            }
            time++;
            System.out.println("还剩余" + (4 - time) + "次机会");
        }
        System.out.println("游戏结束");
    }
}
