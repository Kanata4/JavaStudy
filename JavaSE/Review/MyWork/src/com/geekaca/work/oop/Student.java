package com.geekaca.work.oop;

public class Student {
    public String name;
    public char sex;
    public String hobby;
    //构造方法 构造器 构造函数（特点：无返回值）
    //Java默认提供的 你不写他也有
    public Student(){}
    //有参数的构造器，一旦你提供了自己的构造器，那么java就不会给你生成无参数的构造器了
    public Student(String name0,char sex0,String hobby0){
        name = name0;
        sex = sex0;
        hobby = hobby0;
    }
    public void study() {
        System.out.println("名字：" + name + "，性别：" + sex + "，爱好：" + hobby + "。这位学生开始学习了！");
    }
}
