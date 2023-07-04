package com.geekaca.studentsys;

import java.time.LocalDate;

public class Student {
    private String sid;
    private String name;
    private LocalDate birth;
    private String address;

    public Student() {
        this.sid = sid;
        this.name = name;
        this.birth = birth;
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }

    public String getInfo(){
        return "学号："+ this.sid+" 名字: " +this.name + " 生日:" + this.birth + " 地址："+ this.address;
    }
}
