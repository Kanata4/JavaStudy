package com.geekaca.j2.doujiang;

public abstract class Zhazhiji {
    //洗豆子 or 洗水果
    public abstract void clean();

    //2.放入
    public abstract void putIn();

    public void powerOn() {
        System.out.println("打开电源");
    }

    public final void Zhazhi() {
        //步骤固定
        clean();
        putIn();
        powerOn();
    }
}
