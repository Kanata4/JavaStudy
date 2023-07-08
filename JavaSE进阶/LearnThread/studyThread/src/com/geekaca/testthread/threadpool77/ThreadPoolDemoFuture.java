package com.geekaca.testthread.threadpool77;

import java.util.concurrent.*;

public class ThreadPoolDemoFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 能够拿到线程执行结果的
         * 线程池使用方式
         */
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<String> future1 = pool.submit(new MyCallable(100));
        Future<String> future2 = pool.submit(new MyCallable(200));
        Future<String> future3 = pool.submit(new MyCallable(300));

        //future.get() 阻塞等待结果，拿到结果后，才会放行后续的代码
        System.out.println(future3.get());
        System.out.println(future1.get());
        System.out.println(future2.get());


        pool.shutdown();
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
                + "执行 1-" + n+ "的和，结果是：" + sum;
    }
}
