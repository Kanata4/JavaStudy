package com.geekaca.d3;

public class ForDemo2 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 5; i++) {
//            sum = sum + i;
            sum += i;
            System.out.println(i + " 当前sum的值为" + sum);
        }
        System.out.println("1~5求和结果为" + sum);
    }
}
