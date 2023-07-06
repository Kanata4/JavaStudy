package com.geekaca.testthread;

public class TestSleep {
    public static void main(String[] args) {
        /**
         * 线程休眠
         */
//        TreadSleep treadSleep = new TreadSleep();
//        treadSleep.start();
    }

    class TreadSleep extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println(System.currentTimeMillis());
                try {
                    /**
                     *  比如游戏开发
                     *  FPS 每秒帧数 60fps
                     */
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
