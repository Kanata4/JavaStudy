package com.geekaca.d4.regx;

public class TestRegexDemo4 {
    public static void main(String[] args) {
        /**
         * 字符串分割
         * 替换
         */
        String names = "小路saiodfhiaosdh道具sadoasdjas213小家电doajsf就soda";
        String[] split = names.split("\\w+");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        // 替换 参数1：要找的串 参数2: 要替换成的串
        String name2 = names.replaceAll("\\w+", " ");
        System.out.println("替换后：" + name2);

    }
}
