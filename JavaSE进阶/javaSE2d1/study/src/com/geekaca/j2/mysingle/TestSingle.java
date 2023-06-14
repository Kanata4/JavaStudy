package com.geekaca.j2.mysingle;

/**
 * 懒汉单例模式
 *
 * enum 枚举方式实现单例（扩展）
 */
public class TestSingle {
    public static void main(String[] args) {
        ATMMachine atm = ATMMachine.instance;
        atm.showMoney();
        /**
         * 打印对象的地址一样
         * 说明是同一个对象 单一实例
         */
        System.out.println(atm);
        System.out.println(ATMMachine.instance);
        System.out.println("========懒汉模式========");

        LazyBoy lazyBoy = LazyBoy.getInstance();
        System.out.println(lazyBoy);

        System.out.println(LazyBoy.getInstance());
    }
}
