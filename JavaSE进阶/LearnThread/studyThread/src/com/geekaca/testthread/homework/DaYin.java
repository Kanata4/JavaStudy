package com.geekaca.testthread.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过多线程 ，对一个数字，累加 直到2000 ，或者 2000->0
 */
public class DaYin {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        Thread myThread = new Thread(myRunnable, "Task1");
        Thread myThread1 = new Thread(myRunnable2, "Task2");
        new Thread(new MyRunnable(), "Task3").start();
        myThread.start();
        myThread1.start();

    }
}

class MyRunnable implements Runnable {
    public static int i = 0;
    //静态资源 是只有一份，是共享的
    private static final Object lock = new Object();
    //利用Map结构来保存生成的数字，判断是否有重复  key:  当前i  value： 当前线程名字
    private static Map<Integer, String> map = new HashMap<>();
    //java多线程 规则
    @Override
    public void run() {
        /**
         * 如何捕捉 数字 加多了的情况
         * 如何捕获 重复？
         */
        synchronized (lock) {
            //task1  i = 199
            while (i < 2000) {
                //task1 刚判断完， 线程切换，task2进来了   手里拿到了i=199
                //task1 i 200
                i++;
                Thread curThread = Thread.currentThread();
                /**
                 * {1：task1, 2:task2, 3: task1,}
                 *   3
                 */
                if (!map.containsKey(i)){
                    map.put(i, curThread.getName());
                }else{
                    System.out.println(i + " 已经存在!!!!" + map.get(i)  + " 当前线程：" + curThread.getName());
                }

                System.out.println(curThread.getName() + " i:" + i);

            }
        }
    }
}
