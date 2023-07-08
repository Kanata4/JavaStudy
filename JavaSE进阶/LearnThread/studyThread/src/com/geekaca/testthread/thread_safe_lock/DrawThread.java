package com.geekaca.testthread.thread_safe_lock;

import com.geekaca.testthread.thread_safe_synchronized.Account;

/**
 * 取钱的线程类
 */
public class DrawThread extends Thread {
    // 接收处理的账户对象
    private com.geekaca.testthread.thread_safe_synchronized.Account acc;

    /**
     * 引用关系，依赖关系
     * @param acc
     * @param name
     */
    public DrawThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        // 小明 小红：取钱
        /**
         * 把需要以多线程 方式运行的代码
         * 放在run() 中
         *
         * 用户体验： ”同时运行“
         * 单核CPU  同一个时刻，只能做一件事情  ，实现： 快速切换
         * 多核CPU  真正意义的同时
         */
        acc.drawMoney(100000);
    }
}
