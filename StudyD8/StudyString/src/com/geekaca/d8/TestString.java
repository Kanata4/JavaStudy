package com.geekaca.d8;

public class TestString {
    public static void main(String[] args) {
//        String str = "极客咖";
//        System.out.println(str);
//        str += "hello";
//        System.out.println(str);
//
//        String str2 = new String("极客咖");

//        testStr();
        testStr2();
//        char[] charr = {'A', 'B', 'C'};
//        String s = new String(charr);
//        System.out.println(s);
    }

    public static void testStr2(){
        //字符串 常量池中
        String str = "极客咖";
        String str2 = "极客咖";
        System.out.println(str == str2);
    }

    public static void testStr() {
        /**
         *  存在于常量池中
         */
        String str = "极客咖";
        //新建一个String对象
        String str2 = new String("极客咖");
        /**
         * == 适合判断基本类型
         * 不适合判断引用类型
         *
         * 如果用== 判断两个引用类型变量
         * 判断的是地址
         */
        System.out.println(str == str2);

        //如何判断值是否相等？
        boolean isEq = str.equals(str2);
        System.out.println("equal:" + isEq);

        String info = "tom";
        String info2 = "Tom";
        System.out.println("忽略大小写值：" + info.equalsIgnoreCase(info2));
    }
}