package com.geekaca.testthread.ticket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

public class TestTimer {
    public static void main(String[] args) {
       Thread thread4 = new MyThread2();
       thread4.start();
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        Timer timer = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTimeStr = sdf.format(new Date());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(currentTimeStr);
            }
        },0,1000);
    }
}
