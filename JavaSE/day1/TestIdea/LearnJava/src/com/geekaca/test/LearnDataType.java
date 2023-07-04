package com.geekaca.test;

/*
* class 名字 和文件名要保持一致
*
*
* */
/** 多行注释
 *
 */
public class LearnDataType {
    public static void main(String[] args) {
        // 注释  对代码的备注，解释

        /*
        * 数据类型 变量
        * */

        // 年龄 整数 int 整型变量 定义 保留字 Java自己已经定义的规则，规范
        // age : 变量的名字（有自定义的） 值是23
        // 水杯 可乐 ，喝了又倒了一杯七喜 值在变化 变量名字没有变
        int age = 23;
        // 打印变量
        System.out.println(age);
        age = 24;
        System.out.println(age);
        // 小数 double 双精度 范围更大
        // 小数 默认当作 double 3.14d
        double money = 2134351.0122;
        System.out.println(" 工资 money: " + money);
        // 单精度 范围相对double 要小一点 加f明确表明是 一个float
        float height = 175.5f;
        // 双引号括起来的部分原样输出    + 是连接
        System.out.println(" height: " + height);
        //真假 通常都用is 开头  追求见名知意 开发规范（开发人员的素养）
        boolean isFinished = true;
        System.out.println("是否完成了isFinished：" + isFinished);

        char ch = '廖';
        System.out.println("我姓：" + ch);

        String str = "你好Java";
        System.out.println(str);
        str = "再见同学";
        System.out.println();
    }
}
