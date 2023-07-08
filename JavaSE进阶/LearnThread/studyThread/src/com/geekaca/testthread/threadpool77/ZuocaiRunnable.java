package com.geekaca.testthread.threadpool77;

public class ZuocaiRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        try {
            //为了让当前这个做菜任务 占有一个厨师足够长的时间
            Thread.sleep(1000 * 60 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
