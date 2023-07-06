package com.geekaca.testthread.testfuture.thread_safe;

/**
 * 账户
 */
public class Account {
    //卡号
    private String cardId;
    // 账户的余额
    private double money;

    public Account(){

    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    /**
     * 取钱
       小明 小红
     */
    public void drawMoney(double money) {
        // 0、先获取是谁来取钱，线程的名字就是人名
        String name = Thread.currentThread().getName();
        // 1、判断账户是否够钱
        /**
         * 第一个线程判断后
         * 发生了线程切换
         *
         * 原子性   不可拆分
         *
         * 小明先到柜台了   ，让营业员A看一下 ，余额够不够 10万  ，营业员A：够
         * 一刹那(切换)：小红到了另一个柜台， 让营业员B看一下余额是否够10万， B：足够
         *
         * 小明说取10万，A 执行扣款，交付10万
         * 小红这边，B 执行扣款，交付10万
         */
        if(this.money >= money){
            //在代码逻辑执行中间发生了线程的切换
            // 2、取钱
            System.out.println(name + "来取钱成功，吐出：" + money);
            // 3、更新余额
            this.money -= money;
            System.out.println(name + "取钱后剩余：" + this.money);
        }else {
            // 4、余额不足
            System.out.println(name +"来取钱，余额不足！");
        }

    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
