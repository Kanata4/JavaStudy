package com.geekaca.testthread;

public class TestRunnable2 {
    public static void main(String[] args) {
        /**
         * Runnable方式创建线程
         */
        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
        Thread thread = new Thread(myRunnable, "myThread");
        //启动线程
        thread.start();
//        new Thread(myRunnable).start();
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println(System.currentTimeMillis());
        }
    }
}
