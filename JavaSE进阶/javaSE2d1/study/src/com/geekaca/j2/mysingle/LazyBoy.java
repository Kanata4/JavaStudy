package com.geekaca.j2.mysingle;

/**
 * 懒汉单例模式
 *
 * enum 枚举方式实现单例（扩展）
 */
public class LazyBoy {
    //默认值null
    public static LazyBoy instance;
    private LazyBoy(){}

    public static LazyBoy getInstance(){
        if (instance == null){
            System.out.println("第一次 创建对象");
            instance = new LazyBoy();
        }

        return instance;
    }
}
