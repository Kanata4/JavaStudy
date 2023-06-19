package com.geekaca.j2.computertest;

public class Mouse extends USB{
    public void jieru() {
        System.out.println("usb鼠标入");
    }

    @Override
    public void bachu() {
        System.out.println("usb鼠标拔出");
    }
}
