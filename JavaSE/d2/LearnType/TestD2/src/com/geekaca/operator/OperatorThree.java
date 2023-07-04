package com.geekaca.operator;
public class OperatorThree {
    public static void main(String[] args) {
        int score = 100;
        String result = score >= 60 ?"考试及格":"考试不及格";
        System.out.println();

        int num1 = 12;
        int num2 = 10;
        System.out.println(num1 > num2 ? num1 : num2);
    }
}
