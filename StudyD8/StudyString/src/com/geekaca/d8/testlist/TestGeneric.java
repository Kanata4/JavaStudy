package com.geekaca.d8.testlist;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        /**
         * 泛型
         * 约束集合中只能放指定类型的数据
         *
         * 泛型约束
         * 告诉Java的编译器 只能放xx数据类型
         */
        ArrayList<String> list = new ArrayList<>();
//    arrayList.add(999);
//    arrayList.add(false);
        list.add("java学习");
//        test();
        ArrayList <String>list2 = new ArrayList<>();
        //自动装箱 auto-boxing
//        Integer myAge = new Integer(89);
//        list2.add(89);
//        list2.add(myAge);

        //Objiect是所有类的父类，祖宗类
        /**
         * 暂时了解
         */
        Object obj = list.get(0);
        //强制类型转换
        Integer myInt = (Integer) obj;
    }

    public static void test() {
        /**
         * 笔记！！！
         * 编译阶段
         * 可能出现的错误 问题
         *
         * 运行阶段
         */
//        String s = 9;//类型不匹配
//        age = 99;//变量未定义
//        if(9>0){//语法问题 缺少大括号
        //运行期，runtime
//        System.out.println(9 / 0);
//        String info = null;
//        System.out.println(info.length());
        //NullPointerException 空值异常
    }
}
