package com.geekaca.testthread.homework;


public class TestThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread1(0));
        Thread thread2= new Thread(new MyThread1(1));
        Thread thread3 = new Thread(new MyThread1(2));
        thread1.start();
        thread2.start();
        thread3.start();
    }
    static class MyThread1 implements Runnable {
        private static Object lock = new Object();

        private static int count = 0;

        int no;

        public MyThread1(int no){
            this.no = no;
        }

        @Override
        public void run() {
            while (true){
                synchronized (lock) {
                    if (count >= 2000) {
                        break;
                    }
                    if (count % 3 == this.no){
                        count++;
                        System.out.println(this.no + "--->" + count);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
