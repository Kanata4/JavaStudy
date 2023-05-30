package com.geekaca.d3homework;

public class homework7 {
    public static void main(String[] args) {
        // 打印九行九列 外循环控制行数 内循环控制列数
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + " ");
                if (i == j) {
                    System.out.println("\n");
                }
            }
        }
    }
}

