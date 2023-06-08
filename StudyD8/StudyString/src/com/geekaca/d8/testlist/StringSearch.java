package com.geekaca.d8.testlist;

public class StringSearch {
    public static void main(String[] args) {
        String str = "helloJava";

        boolean isHave = str.contains("ab");
        System.out.println("是否包含：" + isHave);
        //查找指定字符串，返回索引位置
        int index = str.indexOf("va");
        System.out.println("va是否存在：" + index);
    }
}
