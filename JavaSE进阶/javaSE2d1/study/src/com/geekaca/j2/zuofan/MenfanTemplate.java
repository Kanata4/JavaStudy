package com.geekaca.j2.zuofan;

public abstract class MenfanTemplate {
    //1.洗米
    public abstract void ximi();

    //2.放入
    public abstract void putin();

    //3. 开关
    public void poweron(){
        System.out.println("打开电源");
    }

    public void doZuofan(){
        //步骤固定
        ximi();
        putin();
        poweron();
    }


}
