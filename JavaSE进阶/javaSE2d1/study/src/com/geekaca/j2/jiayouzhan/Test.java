package com.geekaca.j2.jiayouzhan;

public class Test {
    public static void main(String[] args) {
        GoldCard myCard = new GoldCard();
        myCard.setMoney(10000);
        myCard.setUserName("zhang");
        myCard.pay(1000);
        System.out.println("剩余：" + myCard.getMoney());

        SliverCard myCard2 = new SliverCard();
        myCard2.setMoney(5000);
        myCard2.setUserName("zhou");
        myCard2.pay(1000);
        System.out.println("剩余：" + myCard2.getMoney());
    }
}
