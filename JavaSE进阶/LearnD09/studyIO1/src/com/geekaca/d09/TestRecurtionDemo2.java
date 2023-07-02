package com.geekaca.d09;

public class TestRecurtionDemo2 {
    public static void main(String[] args) {
        /**
         * 用递归解决 阶乘问题
         *
         * 比如 求5的阶乘
         * 1 * 2 * 3 * 4 * 5
         * 100
         * 1*2*3..*99*100
         */
        int rs = f(2);
        System.out.println("f(1)" + f(1));
        System.out.println("f(2)=" + rs);
        System.out.println("f(3)=" + f(3));

    }

    public static int f(int n){
        //如果n = 1 return 1
        if (n == 1){
            return 1;
        }else {
            //函数一直在进入一个新的函数
            //追踪到f(2) = f(1) * 2 = 1*2 =2
            // 回去 f(3) = f(2) * 3 = 2*3
            //f(4) ...推过去 交给下一个函数 留下n
            return f(n-1) * n;
        }
    }
}
