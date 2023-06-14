package com.geekaca.j2.extends_test;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(12);
        stu.setName("zhang");
        System.out.println(stu.getAge() + stu.getName());
    }
}
