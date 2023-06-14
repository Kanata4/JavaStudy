package com.geekaca.j2.extends_school;

public class People {
    public String name;
    public int age;

    public static void lookLesson(){
        System.out.println("查看课表");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
