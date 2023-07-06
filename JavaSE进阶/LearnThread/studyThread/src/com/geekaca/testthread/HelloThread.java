package com.geekaca.testthread;

import java.util.Scanner;

public class HelloThread {
    public static void main(String[] args) {
        /**
         * 线程创建
         */
        System.out.println("hello");
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
        }
        System.out.println("bye");
        //创建线程，启动
        MyTread myTread = new MyTread();
        MyTread2 myTread2 = new MyTread2();
        myTread2.setName("Task1");
        MyTread2 myTread21 = new MyTread2();
        myTread21.setName("Task2");
        myTread2.start();
        myTread21.start();
//        myTread.run();
        //调用start 是通知java虚拟机 线程准备好了 可以启动了
        myTread.start();

//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        System.out.println(next);
        ShowThread showThread = new ShowThread();
        showThread.start();
        String mainName = Thread.currentThread().getName();
        System.out.println("main方法所在线程的名字：" + mainName);

    }
}
class MyTread extends Thread{
    /**
     * 规则：java语言设定好的 你必须去遵照 才能具备对应的能力
     * 重写父类的方法
     * 在run中放入的代码 获得的能力
     *
     * 以多线程的方式运行
     * 能够交替执行
     *
     * run()不是由我们调用的 是由JDK java语言机制调用的
     */
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            //当代码执行到此处的时候 休息一秒钟
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " i: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
