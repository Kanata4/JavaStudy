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
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("请输入学号：");
            String inputNum = scanner.next();
            findStuById(students,inputNum);
            //equals 完全匹配，是否相等
//                if (studNo.equals(student.getStuNo())){
//                    //找到了
//                    System.out.println("找到了" + student);
//                    isFound = true;
//                }
        }//end for循环
        //最终没有符合条件的 学生
//            if (!isFound) {
//                System.out.println("没找到 学号为 " + inputNum + "的学生");
//            }
        }
    /**
     * 根据学号模糊查询学生
     * @param stuList 存储了所有学生的集合
     * @param stuNo 学号
     */
    public static void findStuById(ArrayList<Student> stuList, String stuNo) {
        //是否找到了
        boolean isFound = false;
        //循环访问学生集合，和每一个比较学号
        for (int i = 0; i < stuList.size(); i++) {
            Student student = stuList.get(i);
            //只是判断当前这个学生 他学号不符合 不代表后面就没有了

            //模糊查询： 当前学生的学号是否 含有 用户输入的字符串 stuNO
            String stuId = student.getStuNo();//当前学生的学号
            /**
             * 判断 stuId这个字符串中是否 含有 用户输入的字符串 inputNum
             *
             */
            if (stuId.contains(stuNo)) {
                System.out.println("找到了含有学号" + stuNo + "的学生：" + student.toString());
            }
        }
    }
}

