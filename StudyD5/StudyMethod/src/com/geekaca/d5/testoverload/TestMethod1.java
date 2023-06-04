package com.geekaca.d5.testoverload;

public class TestMethod1 {
    public static void main(String[] args) {
        fire();
        fire("世界的哪个地区");
        System.out.println();
    }

    public static void fire() {
        System.out.println("开火");
    }
    //看类型 不看函数名字 函数名字相同 返回值不同
    public static void fire(String location) {
        System.out.println("向" + location + "开火");
    }
}
