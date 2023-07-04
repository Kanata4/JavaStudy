package com.geekaca.operator;

public class OperatorYouxianji {
    public static void main(String[] args) {
        /**
         * 优先级
         * / 优先级大于+ -
         *  () 优先级最高
         */
        System.out.println(10 > 3 || 10 > 3 && 10 < 3);
        // 用括号明确的分隔 意图，避免歧义
        System.out.println((10 > 3 || 10 > 3) && 10 < 3);

        String str = "";
    }

}
