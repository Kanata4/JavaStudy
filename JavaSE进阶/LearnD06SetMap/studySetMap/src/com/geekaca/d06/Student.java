package com.geekaca.d06;

import java.util.Objects;

public class Student {
    private String name;
    private String ID;

    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int hashCode() {
        //生成一个hash值 依赖当前对象的各个属性值 组合在一起 生成唯一的值
        return Objects.hash(name,ID);
    }

    /**
     * 依赖他来判断两个对象是否值相同
     * 放入Set的适合 被当做一个值处理 去掉重复
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            //说明自己跟自己比较
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student stu = (Student) obj;
        return this.name.equals(stu.getName()) && this.ID.equals(stu.getID());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
