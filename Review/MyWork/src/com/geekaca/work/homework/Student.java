package com.geekaca.work.homework;

public class Student {
    //成员变量，成员属性 有默认值
    public String name;
    public String className;

    /**
     * 回答问题
     * @param shijuan 试卷对象 载体 钥匙号牌
     *
     * 引用类型： 数组 对象 （类对象，String）
     */
    public void dajuan(Shijuan shijuan){
        for (int i = 0; i < shijuan.questions.length; i++) {
            /**
             * 改变 试卷的属性值 类似于改变 钥匙号牌指向的柜子里的内容
             */
            shijuan.answers[i] = "回答" + i;
        }
    }

}
