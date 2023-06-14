package com.geekaca.j2.extends_school;

import com.geekaca.j2.extends_test.People;

public class Student extends People {
    private String className;
    public void writeAdvice(){
        System.out.println("填写听课反馈");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
