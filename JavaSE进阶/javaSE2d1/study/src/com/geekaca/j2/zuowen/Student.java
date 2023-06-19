package com.geekaca.j2.zuowen;

public abstract class Student {

    private String title;
    private String endStr;


    public void setTitle(String title){
        this.title = title;

    }
    //正文 由子类来实现
    public abstract String writeMain();

    public void setEnd(String endStr){
        this.endStr = endStr;
    }

    //不允许子类修改格式
    public final void showWord(){
        System.out.println("标题：" + this.title);
        System.out.println("正文："  + writeMain());
        System.out.println("结尾：" + this.endStr);
    }
}
