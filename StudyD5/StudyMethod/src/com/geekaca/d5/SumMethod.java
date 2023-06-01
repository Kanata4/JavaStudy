package com.geekaca.d5;

public class SumMethod {
    public static void main(String[] args) {
        /**
         * 方法：
         *
         * 1.输入？ int:n
         * 2.输出？int
         */
        System.out.println(sumToN(2000));
    }
    public static int sumToN(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
