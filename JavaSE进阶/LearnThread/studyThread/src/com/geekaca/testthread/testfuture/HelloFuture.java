package com.geekaca.testthread.testfuture;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class HelloFuture {
    public static void main(String[] args) {
        /**
         * 获得线程执行的结果
         */
        Callable<String> mycall = new MyCallable(1000);
        FutureTask<String> futureTask = new FutureTask<>(mycall);

        Thread t1 = new Thread(futureTask,"Thread1");
        /**
         * 调用start只是通知cpu 此线程对象准备好了 可以启动了
         * 但是具体谁先启动 取决于cpu调度 并不是代码顺序
         */
        t1.start();

        Callable<String> my2 =new MyCallable(200);
        FutureTask<String> futureTask1 = new FutureTask<>(my2);
        new Thread(futureTask1,"Thread2").start();

        String result = null;
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("我的线程结果：" + result);

        String rs = null;
        try {
            rs = futureTask1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("第二个线程结果：" + rs);

    }
}
//泛型约束 执行的返回结果
class MyCallable implements Callable<String>{
    private int number;

    public MyCallable(int number){
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        System.out.println("开始累加：" + number);
        int sum = 0;
        for (int i = 0; i < number; i++) {
            Thread.sleep(1000);
            //获取当前线程的名字
            System.out.println(Thread.currentThread().getName()+ " " + i);
            sum += i;
        }
        return "线程进行累加的结果：" + sum;
    }
}
