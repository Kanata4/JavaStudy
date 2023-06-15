package com.geekaca.j2.usb;

public class Mouse extends USB{
    @Override
    public void jieru() {
        System.out.println("鼠标启动了");
    }

    @Override
    public void bachu() {
        System.out.println("鼠标关闭了");
    }
}
