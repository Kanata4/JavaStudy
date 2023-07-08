package com.geekaca.testthread.thread_safe_synchronized;

import com.geekaca.testthread.threadpool77.ZuocaiRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        /**
         * 线程池 比较简便的创建方式
         */
        //只要线程数不够用了 就新建线程 容易把内存涨满
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ZuocaiRunnable());
        executorService.execute(new ZuocaiRunnable());
        executorService.execute(new ZuocaiRunnable());
        executorService.execute(new ZuocaiRunnable());
        //固定数量的线程池 unbounded
        ExecutorService executorServiceOPool = Executors.newFixedThreadPool(2);
        //单一线程
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();


        //定时器
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
        //按照固定的时间间隔 执行一个任务 参数2 delay 开始执行前 0 立即开始
        scheduledPool.scheduleAtFixedRate(new TestRunnable(),0,1, TimeUnit.SECONDS);
        //执行一次 one-shot 适合延迟多少秒 分钟之后执行一个任务
        scheduledPool.schedule(new TestRunnable(),1,TimeUnit.SECONDS);
        scheduledPool.shutdownNow();

    }
}

class TestRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello" + System.currentTimeMillis());
    }
}
