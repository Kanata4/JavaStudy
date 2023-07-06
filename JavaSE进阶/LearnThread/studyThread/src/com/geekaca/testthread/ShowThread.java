package com.geekaca.testthread;

public class ShowThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
