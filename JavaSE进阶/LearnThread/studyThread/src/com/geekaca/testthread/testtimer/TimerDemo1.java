package com.geekaca.testthread.testtimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //匿名内部类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行AAA" + new Date());
            }
        },0,2000);
    }
}
