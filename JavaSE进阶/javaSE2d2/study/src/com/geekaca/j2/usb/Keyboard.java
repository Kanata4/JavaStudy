package com.geekaca.j2.usb;

public class Keyboard extends USB{
    @Override
    public void jieru() {
        System.out.println("键盘启动了");
    }

    @Override
    public void bachu() {
        System.out.println("键盘关闭了");
    }
}
