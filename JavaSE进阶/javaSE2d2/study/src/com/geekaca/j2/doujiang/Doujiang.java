package com.geekaca.j2.doujiang;

public class Doujiang extends Zhazhiji{
    public Doujiang(){
        System.out.println("开始制作豆浆");
    }

    @Override
    public void clean() {
        System.out.println("洗豆子");
    }

    @Override
    public void putIn() {
        System.out.println("把洗好的豆子放进榨汁机");
    }

}
