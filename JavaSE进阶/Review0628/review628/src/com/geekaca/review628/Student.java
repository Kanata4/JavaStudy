package com.geekaca.review628;

public class Student {
    private Integer id;
    private String name;
    private char sex;
    private Integer age;
    private String className;

    public Student(Integer id, String name, char sex, Integer age, String className) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
