package com.geekaca.d3;

public class ForDemo3 {
    public static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
//            int rs = i % 2;
//            if (rs == 1){
//                System.out.println(i + "是奇数");
//            }
//        }
        /**
         * 统计奇数的个数
         */
        int sum = 0;
        int jishuNum = 0;
        for (int i = 1; i <= 10; i++) {
            int rs = i % 2;
            if (rs == 1) {
                jishuNum++;
                System.out.println(i + "是奇数");
                sum += i;
            }
        }
        System.out.println("奇数的个数为：" + jishuNum + "个");
        System.out.println("奇数的和为：" + sum);
    }
}
