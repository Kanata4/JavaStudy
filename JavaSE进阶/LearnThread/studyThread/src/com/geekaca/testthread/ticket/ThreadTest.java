package com.geekaca.testthread.ticket;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class MyThread extends Thread{
    private static int ticket = 1;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    public static synchronized void show(){
        if (ticket <= 20){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "已售出：" + ticket + "张票");
            ticket++;
        }
    }
}
