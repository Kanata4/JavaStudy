package com.geekaca.testthread.threadpool77;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        /**
         * 线程池 比较简便的创建方式
         */
        //只要线程数不够用了，就新建线程， 容易把内存涨满
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new ZuocaiRunnable());
//        executorService.execute(new ZuocaiRunnable());
//        executorService.execute(new ZuocaiRunnable());
//        //固定数量的线程池  unbounded queue  任务队列没有长度限制 ，队列容易胀满
//        ExecutorService executorServicePool = Executors.newFixedThreadPool(5);
//        executorServicePool.execute(new ZuocaiRunnable());
//        executorServicePool.execute(new ZuocaiRunnable());
//        executorServicePool.execute(new ZuocaiRunnable());
//        //池中只有一个线程  ，但是 unbounded queue 队列无限制 ，容易胀满
//        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
//        executorServiceSingle.execute(new ZuocaiRunnable());
//        executorServiceSingle.execute(new ZuocaiRunnable());
//        executorServiceSingle.execute(new ZuocaiRunnable());
        /**
         * 自己明确知道，而且可以控制，向线程池提交的任务数量
         * 那么可以使用以上三种
         */

        //定时器
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        //按照固定的时间间隔，执行一个任务  参数2： delay ,开始执行前等待时间  0 立即开始
        /**
         * 适合开发 重复执行的任务
         * Linux 操作系统，CRON 定时任务的工具
         */
        scheduledPool.scheduleAtFixedRate(new TestRunnable(), 0, 1, TimeUnit.SECONDS);
        //执行一次one-shot 适合延迟多少秒，分钟之后执行一个任务
//        scheduledPool.schedule(new TestRunnable(), 1 , TimeUnit.SECONDS);
//        scheduledPool.shutdownNow();
    }
}

class TestRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello 做包子:" + Thread.currentThread().getName() +" "+ System.currentTimeMillis());

    }
}
