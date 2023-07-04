package com.geekaca.work.oop;

public class TestMain {
    public static void main(String[] args) {
        // 类=设计图 对象=真是存在的具体实例
        //自己定义的类型 class类型
        //car 对象 实例 创建对象 New 实例化
        /**
         * c1 钥匙号牌 存储的是地址
         * Car对象 储物柜
         * 对象（数组，String） 属于引用类型
         * 对象存在于堆内存中
         */
        Car c1 = new Car();
        c1.color = "蓝色";
        c1.name = "比亚迪";
        c1.price = 179000.9;
        c1.drive();
        c1.showInfo();
        //展示类的属性默认值
//        Car myCar = new Car();
//        System.out.println(myCar.height);
//        System.out.println(myCar.color);
        Car c2 = new Car();
        c2.color = "红色";
        c2.name = "奥迪";
        c2.price = 300000.0;
    }
}
