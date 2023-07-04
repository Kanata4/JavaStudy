package com.geekaca.testwhile;

public class TestBreak {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println("刷碗第" + i + "天");
            if (i == 12) {
                break;
            }
        }

        for (int i = 1; i <= 30; i++) {
            // 12 13 这两天 你家孩子惹祸了 孩子刷 后面还是你
            if (i == 12 || i == 13) {
                continue;
            }
            System.out.println("刷碗第" + i + "天");
        }
    }
}
