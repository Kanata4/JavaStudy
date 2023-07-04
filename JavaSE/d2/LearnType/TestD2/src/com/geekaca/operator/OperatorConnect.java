package com.geekaca.operator;

public class OperatorConnect {
    public static void main(String[] args) {
        /**
         * 字符操作
         * 了解：
         * ASCII编码 针对英文字母和数字，都有对应的一个整数代表
         * A~Z
         * a~z
         * 0~9
         * A的ASCII码是65
         * A~Z是依次递增的
         */
        char ch1 = 'A';
        System.out.println(ch1 + 1);
        int numOfB = 'B';
        System.out.println("B 这个字符的ASCII码值：" + numOfB);
        System.out.println("=========下面是数字=======");
        // 从左到右执行
        System.out.println(99 + 1 + "结果？");
        String str2 = "ABC" + (99 + 1);
        System.out.println(str2);


    }
}
