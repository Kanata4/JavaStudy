package com.geekaca.d8.testlist;

/**
 * 类 对象
 * 把学生信息封装在了类中
 *
 * 类 起到了模板功能
 * 创建的学生对象 都具有同样的结构
 */
public class Student {
    private String stuNo;
    private String name;
    private int age;
    private String className;

    public Student() {
    }

    public Student(String stuNo, String name, int age, String className) {
        this.stuNo = stuNo;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
