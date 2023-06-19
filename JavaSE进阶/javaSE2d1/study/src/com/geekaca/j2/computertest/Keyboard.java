package com.geekaca.j2.computertest;

public class Keyboard extends USB{
    @Override
    public void jieru() {
        System.out.println("usb键盘键入");
    }

    @Override
    public void bachu() {
        System.out.println("usb键盘拔出");
    }
}
