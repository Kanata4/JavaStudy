package com.geekaca.j2.doujiang;

public class Juice extends Zhazhiji{
    public Juice() {
        System.out.println("开始榨水果汁");
    }

    @Override
    public void clean() {
        System.out.println("洗水果");
    }

    @Override
    public void putIn() {
        System.out.println("把洗好的水果放进榨汁机");
    }
}
