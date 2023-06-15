package com.geekaca.j2.usb;

public class Computer {
    //要求USB类型的变量 对象，引用类型变量
    public void connectAndLeaveUSB(USB usb){
        usb.jieru();
        System.out.println("执行一些操作");
        usb.bachu();
    }

}
