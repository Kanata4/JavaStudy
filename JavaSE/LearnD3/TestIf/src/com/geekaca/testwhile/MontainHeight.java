package com.geekaca.testwhile;

public class MontainHeight {
    public static void main(String[] args) {
        double montainHeight = 8848.86 * 1000;
        double paperHeight = 0.2;
        double nowHeight = paperHeight;
        int count = 0;
        while (nowHeight < montainHeight) {
            nowHeight = nowHeight * 2;
            count++;
        }
        System.out.println("折叠了" + count + "次");
    }
}
