package com.geekaca.d8.testlist;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSearchName {
    public static void main(String[] args) {
        //集合ArrayList练习
        //根据输入的学生名字，模糊查询
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        students.add(new Student("20180302", "张维", 23, "护理一班"));
        students.add(new Student("20180303", "张杰", 23, "推拿二班"));
        students.add(new Student("20180304", "刘备", 26, "中药学四班"));
        students.add(new Student("20180305", "刘邦", 26, "神经科2班"));

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("学生的信息为：");
            System.out.println(student.getStuNo() + " " + student.getName() + " " +
                    student.getAge() + " " + student.getClassName());
        }

        while (true) {
            System.out.println("请输入姓名：");
            String inputName = sc.next();
            boolean isFound = false;
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);//一个个叫到面前
                String stuName = student.getName();//当前学生的名字
                if (inputName.equals(student.getName())) {
                    //找到了
                    System.out.println("找到了" + student);
                    isFound = true;
                    break;
                }
                if (stuName.contains(inputName)) {
                    System.out.println("模糊搜索结果：" + student.toString());
                }
            }
            if (!isFound) {
                System.out.println("没找到姓名为 " + inputName + "的学生");
            }
        }
    }
}
