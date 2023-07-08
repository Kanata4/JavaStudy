package com.geekaca.testthread.threadpool77;

import java.util.concurrent.*;

public class ThreadPoolDemo2Reject {
    public static void main(String[] args) {
        ArrayBlockingQueue waitQueue = new ArrayBlockingQueue<>(5);
        /**
         * 厨房默认放3个厨师 不够用的话再雇佣 最多达到五个
         * 如果发现空闲了 多雇佣的临时工 最多空闲10秒 超过十秒解雇
         * 等待制作的菜 队列最多有五个菜
         *
         * 如果已经达到了五个厨师 都在忙
         * 还有五个菜 等着做
         * 又来新的做菜需求了
         */
        ExecutorService threadPool = new ThreadPoolExecutor(3,5,10, TimeUnit.SECONDS,
                waitQueue, Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //向线程池提交任务
        ZuocaiRunnable zuocai = new ZuocaiRunnable();
        //核心三个厨师 三个核心线程
        threadPool.execute(zuocai);
        threadPool.execute(zuocai);
        threadPool.execute(zuocai);
        //拓展两个 额外雇佣两个厨师
        threadPool.execute(zuocai);
        threadPool.execute(zuocai);

        //再加五个菜的订单 进入等待队列 把任务的等待队列占满
        for (int i = 0; i < 5; i++) {
            threadPool.execute(zuocai);
        }
        //再加一个订单 java.util.concurrent.RejectedExecutionException
        //厨师线程都在占用 等待队列也满了
        threadPool.execute(zuocai);
//        threadPool.shutdown();
    }
}
