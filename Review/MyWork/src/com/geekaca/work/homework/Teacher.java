package com.geekaca.work.homework;

public class Teacher {
    public String name;
    public int age;
    public char sex;

    public Teacher(){

    }

    //alt + insert
    //全选属性，按住shift按键
    public Teacher(String name, int age, char sex) {
        //this 代表当前对象
        //this.name 当前对象（你创建的对象）的属性
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 出题
     * @param number 出题数量
     * @return
     */
    public Shijuan chuti(int number) {
        Shijuan shijuan = new Shijuan();
        shijuan.questions = new String[10];
        shijuan.answers = new String[10];
        for (int i = 0; i < shijuan.questions.length; i++) {
            shijuan.questions[i] = "test " + i;
        }
        return shijuan;
    }

    /**
     * 批阅试卷
     * 符合javadoc格式的注释
     *
     */
    public double piyue(Shijuan shijuan) {return 99.9;}
}

