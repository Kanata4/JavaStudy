package com.geekaca.j2.override_test;

public class Phone {
    public void call(){
        System.out.println("打电话");
    }

    public void sendMsg(){
        System.out.println("发短信");
    }

    private void IMEI(){
        System.out.println("IMEI");
    }

    public static void show(){}
}
