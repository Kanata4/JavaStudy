package com.geekaca.test;

public class LearnIf {
    public static void main(String[] args) {
        /**
         * 学习Java 判断语句
         *
         * 比如： 1.判断 年龄》18， 则打印 成年人
         *  否则 打印 ： 未成年
         *
         * 2， 消费金额大于1000，那么就打八折
         * 否则，原价支付
         *
         */
        int yourAge = 12;
        if (yourAge > 18){
            System.out.println("成年人");
        }else{
            System.out.println("未成年人");
        }
        // 消费金额
        double costMoney = 2400;
        // 逻辑判断 如果括号中的表达式 结果是true 那么就会执行接下来的大括号内容
        if (costMoney > 1000){
            //            结果是ture： 执行
            costMoney = costMoney * 0.8;
            System.out.println("打八折后需要支付金额：" + costMoney);
        }else{
            //表达式判断结果为false  则执行这里
            System.out.println("未打折，需要支付金额：" + costMoney);
        }
        /**
         * 代码格式化 自动清理 对齐代码
         */
    }
}
