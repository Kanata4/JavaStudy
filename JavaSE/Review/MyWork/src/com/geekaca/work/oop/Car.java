package com.geekaca.work.oop;

import java.util.SplittableRandom;

public class Car {
    //类的属性 类的变量 描述车的颜色
    //成员变量 默认值
    public String color;
    public String name;
    public double price;
    //高度
    public int height;
    //成员方法
    public void showInfo(){
        System.out.println("名字：" + name + "价格" +  price);

    }
    public void drive() {}

}
//只能有一个pulic
//通常不在同一个文件声明多个类
class Cat{
    public String name;
}
