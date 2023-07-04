package com.geekaca.d5;

import java.util.SplittableRandom;

/**
 * Java 编译型
 * Javascript 解释型语言
 */

public class MethodDemo1 {
    /**
     * 求和
     * javadoc 格式的注释
     *
     * @param a 变量1
     * @param b 变量2
     * @return 结果 对返回值的备注
     * <p>
     * int 方法（函数） 返回值类型 sum 方法名, 自定义的(函数的形式参数，用来描述函数能够接受的函数 a b 自定义)
     */
    public static int mySum(int a, int b) {
        System.out.println("a:" + a);
        return a + b;
        //不可到达 函数结束了
//        int i = 0;
        //返回值类型要匹配
//        return 9.9;
    }

    public static void main(String[] args) {
        //传递进去的9和1 实际参数
        int result = mySum(9, 1);
        System.out.println(result);
        printInfo();

        //可以不接收结果，返回值
//        getInfo(23);
//        String info = getInfo(23);
//        System.out.println(info);
        /**
         * getInfo 返回一个String println(可以接收String)
         * 直接组合
         */
        System.out.println(getInfo(12));
        //不能打印void
//        System.out.println(printInfo());

    }

    //void(无返回值)
    public static void printInfo() {
        //不能嵌套
//        public static void(){}
        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                //结束for循环
                //break;
                //结束函数的执行 当前函数
                return;
            }
            System.out.println("=========");
        }
        System.out.println("test!!!");
        //void不能有返回值
//        return "test";
    }

    public static String getInfo(int age) {
        if (age >= 18) {
            return "已成年";
        } else {
            return "未成年";
        }
    }
}
