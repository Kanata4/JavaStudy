package com.geekaca.testthread.thread_safe_synchronized;

import java.util.concurrent.*;

public class ThreadPoolDemoFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 能够拿到线程执行结果的
         * 线程池使用方式
         */
        ArrayBlockingQueue waitQueue = new ArrayBlockingQueue<>(20);
        ExecutorService pool = new ThreadPoolExecutor(3,5,10,TimeUnit.SECONDS,
                waitQueue,Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<String> future1 = pool.submit(new MyCallable(100));
        Future<String> future2 = pool.submit(new MyCallable(200));
        Future<String> future3 = pool.submit(new MyCallable(300));

        //future.get() 阻塞等待结果
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}
class MyCallable implements Callable<String>{
    private int n;
    public MyCallable(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += n;
        }
        return Thread.currentThread().getName()
                + " 执行 " + n + " ";
    }
}