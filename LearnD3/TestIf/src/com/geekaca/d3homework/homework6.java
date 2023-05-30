package com.geekaca.d3homework;

public class homework6 {
    public static void main(String[] args) {
        for (int year = 1949; year < 2019; year++) {
            int num1 = (2019 - year) % 12;
            if (num1 % 12 == 0) {
                System.out.println(year);
            }
        }
    }
}
