package com.geekaca.test;

import java.util.ArrayList;

public class TestInteger {
    public static void main(String[] args) {
        /**
         * 包装类
         * Java追求一切皆对象
         */
        ArrayList<Integer> list = new ArrayList();
        /**
         * 笔记
         * 需要记住 集合只能放引用类型
         * 不能放基本类型
         *
         * 这种写法可以 因为发生了自动类型转换
         */
        list.add(9);
        /**
         * java自动帮你创建了Integer对象 包装类 方便能够把基本类型 经过包装放入集合
         *自动装箱
         *
         * 集合类似集装箱 要求放进去的货物 必须打包 不能拿个塑料袋要邮寄一袋子
         */
        //deprecated 不推荐使用 可能会在后续的JDK版本中删除这个构造器
//        list.add(new Integer(9));
        list.add(Integer.valueOf(9));
        //正经写法
        Integer integer = list.get(0);
        //不正经写法 偷懒写法  自动拆箱
        int theInt = integer.intValue();
        int myInt = list.get(0);

        /**
         * 类型转换
         * int -> 包装类
         * 包装类 -> int
         * String 转换
         *
         * Integer
         * Float/Double
         */

        //int基本类型 -> 包装类
        Float aFloat = Float.valueOf(9.9f);
        //包装类 -> int基本类型
        float fValue = aFloat.floatValue();
        //String -> 基本类型
        float vf = Float.parseFloat("9.9f");
        //基本类型->String
        String s = 9 + "";
        Integer.toString(99);




    }
}
