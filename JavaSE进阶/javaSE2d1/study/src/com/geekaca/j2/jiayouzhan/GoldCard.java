package com.geekaca.j2.jiayouzhan;

public class GoldCard extends Card {
    @Override
    public void pay(double money2) {
        System.out.println("金卡用户");
        System.out.println("您当前消费：" + money2);
        System.out.println("您的卡片余额为：" + getMoney());

        double payMoney = money2 * 0.8;
        System.out.println(getUserName()+ "先生，您实际支付：" + payMoney);

        setMoney(getMoney() - payMoney);
    }
}
