package com.geekaca.j2.mysingle;

/**
 * 饿汉单例
 */
//期望单一对象 单一实例
public class ATMMachine {
    //饿汉单例
    public static ATMMachine instance = new ATMMachine();
    private ATMMachine() {

    }

    public void showMoney() {
        System.out.println("吐出十万");
    }
}
