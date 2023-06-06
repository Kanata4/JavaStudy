package com.geekaca.work.homework;

public class TestMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //局部变量 方法内部定义的
        String name;
        //无默认值，想要使用必须自己初始化赋值
        test2();
    }

    public static void test2() {
        Teacher teacher = new Teacher("shan",43,'男');
        for (int i = 0; i < 3; i++) {
            Shijuan juanzi = teacher.chuti(10 + i);
            Student stu = new Student();
            stu.name = "Tom" + i;
            stu.dajuan(juanzi);
            double score = teacher.piyue(juanzi);
            System.out.println(stu.name + "得分：" + score);
        }
    }

    public static void test1() {
        String str = new String("hello");

        Teacher teacher = new Teacher("shan",43,'男');
        //老师创建的试卷对象
        Shijuan juan = teacher.chuti(4);

        Student stu = new Student();
        /**
         * 学生对象，对试卷对象进行修改
         * 对象 当作函数参数 传递
         */
        stu.dajuan(juan);
        System.out.println("学生回答后，试卷上的答案");
//        juan能否获得修改
        for (int i = 0; i < juan.answers.length; i++) {
            System.out.println(juan.answers[i]);
        }
    }


}
