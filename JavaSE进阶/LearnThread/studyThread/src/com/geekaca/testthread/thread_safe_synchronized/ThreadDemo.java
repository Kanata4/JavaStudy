package com.geekaca.testthread.thread_safe_synchronized;



public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 模拟多个线程同时取钱
         */
        //夫妻二人公共的账户   引用类型  ，传入函数的是引用，类似钥匙号牌  ，两个人不同的钥匙
        //指向的是同一个柜子
        Account account = new Account("99998888", 100000);
        DrawThread xiaomingThread = new DrawThread(account, "小明");
        DrawThread xiaohongThread = new DrawThread(account, "小红");
        //用线程方式 模拟 同时取钱
        xiaomingThread.start();
        xiaohongThread.start();
    }
}
