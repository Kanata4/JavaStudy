package com.geekaca.d4.regx;

public class TestRegexDemo2 {
    public static void main(String[] args) {
        //默认匹配一个字符
        System.out.println("a".matches("[abc]"));
        System.out.println("m".matches("[abc]"));
        System.out.println("ab".matches("[abc]"));
        // 除了
        System.out.println("^abc " + ("a".matches("[^abc]")));
        System.out.println("^abc " + ("z".matches("[^abc]")));
        //单个字母
        System.out.println("[a-z] " + ("uf".matches("[a-z]")));
        System.out.println("[a-z] " + ("u".matches("[a-z]")));
        System.out.println("9".matches("[0-9]"));
        // \d 数字
        System.out.println("==============");
        //转义字符 让他后面挨着的字符时区原本的含义
//        System.out.println("\");
        //让转义字符失去 转义的作用
        System.out.println("6是否是一个数字： " + ("6".matches("\\d")));
        System.out.println("r是否是一个数字： " + ("6".matches("\\D")));
        //英文 数字 下划线
        System.out.println("z死否符合英文，数字，下划线");
        System.out.println("z".matches("\\w"));
        System.out.println("$".matches("\\w"));
        System.out.println("汉".matches("\\w"));
        System.out.println("非单词字符\\W");
        System.out.println("你".matches("\\W"));

        //密码格式校验 要求
        boolean isMatched = "admin123".matches("\\w{6,}");
        System.out.println("admin123是否符合 " + isMatched);
        System.out.println("5555".matches("\\w{6,}"));

        //验证码 数字和字母 只有四位
        //每一位只能是数字和字母
//        "[a-zA-Z0-9]"
//        "[a-zA-Z0-9]{4}"只有四位
        String rule = "[a-zA-Z0-9]{4}";
        System.out.println("34ar".matches(rule));
        System.out.println("34_F".matches(rule));

        //可以 在\w 规则基础上 把下划线去掉
        //字母 数字 下划线
        //符合 并且（&&）去掉下划线
        System.out.println("34ar".matches("[\\w&&[^_]]{4}"));
        System.out.println("34_F".matches("[\\w&&[^_]]{4}"));
    }
}
