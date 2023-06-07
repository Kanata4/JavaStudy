package com.geekaca.d8.testlist;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSearch {
    public static void main(String[] args) {
        /**
         * 死循环 根据学号搜索学生 (学号，姓名，年龄，班级）
         * 1.设计类 封装学生
         * 2.死循环 接受输入 学号，找到则打印学生信息
         * 找不到 则提示找不到
         */
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180302", "叶孤城", 23, "护理一班"));
        students.add(new Student("20180303", "东方不败", 23, "推拿二班"));
        students.add(new Student("20180304", "西门吹雪", 26, "中药学四班"));
        students.add(new Student("20180305", "梅超风", 26, "神经科2班"));

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("学生的信息为：");
            System.out.println(student.getStuNo() + " " + student.getName() + " " +
                    student.getAge() + " " + student.getClassName());
        }


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学号：");
            String inputNum = scanner.next();
            Student student = findStudent(students, inputNum);
            if (student == null) {
                System.out.println("找不到这个学生");
            } else {
                System.out.println(student.getStuNo() + " " + student.getName() + " " +
                        student.getAge() + " " + student.getClassName());
                break;
            }
        }
    }

    public static Student findStudent(ArrayList<Student> students, String stuId) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if ((student.getStuNo().equals(stuId))) {
//                System.out.println("学生的信息为：");
//                System.out.println(s.getStuNo() + " " + s.getName() + " " + s.getAge() + " " + s.getClassName());
                return student;
            }
        }
        return null;
    }
}
