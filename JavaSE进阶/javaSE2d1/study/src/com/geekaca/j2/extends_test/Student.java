package com.geekaca.j2.extends_test;

/**
 * 子类
 * 关键字 extends
 */
public class Student extends People{
    public void showSecret(){
        //子类无法直接访问父类的私有属性 方法 需要通过公共方法访问
//        System.out.println(secret);
    }

    public void study(){
        System.out.println("学生学习");
    }
}
