package com.geekaca.j2.extends_school;

import com.geekaca.j2.extends_test.People;

public class Teacher extends People {
    private String dept;
    public void askQuestion(){
        System.out.println("发布问题");
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }



}
