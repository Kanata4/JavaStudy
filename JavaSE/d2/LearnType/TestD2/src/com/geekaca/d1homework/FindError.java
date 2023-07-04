package com.geekaca.d1homework;

public class FindError {
    public static void main(String[] args) {
        int a = 10;
        {
            a = 20;
            System.out.println(a);
        }

            //大括号 约束了，限定了一个变量的影响，存活范围
            /**
             * 范围 变量的作用域
             */
            //1年1班 你有个绰号 智多星 你们班级都知道
            int b = 20;
            System.out.println(b);

        // 解决方法 去掉大括号
        b = 30;
        System.out.println(b);

        System.out.println("=======定义两个整数型，打印加和==========");
        int number1 = 99;
        int num2 = 88;
        //ctrl + z 撤销
        int result = number1 + num2;
        //整型 + 字符串 叫 连接
        System.out.println(number1 + "+" + num2 + "=" + result);


    }
}
