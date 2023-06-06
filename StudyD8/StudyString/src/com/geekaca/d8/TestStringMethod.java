package com.geekaca.d8;

public class TestStringMethod {
    public static void main(String[] args) {
        String str = "abcd,{中";
        //            01234
        System.out.println("长度：" + str.length());


        System.out.println("第一个字符：" + str.charAt(0));
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("最后一个字符: " + lastChar);

        //转成字符数组
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
        //取字符串的子串  ,取前三个字符  0,1,2
        //ctrl+ q 查看函数文档
        String substring = str.substring(0, 3);
        System.out.println(str + " 的子串 （包含前三个字符）：" + substring);

        //从 索引3取到末尾
        String subStrToEnd = str.substring(3);
        System.out.println(str + " 从索引3到末尾子串：" + subStrToEnd);

        //把{ 替换成#
        String replaced = str.replace("{", "#");
        System.out.println(replaced);

        //分割字符串
        String myStr = "Tom,Jerry,刘备，吴用";
        System.out.println("========================");
        String[] split = myStr.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
