package com.geekaca.j2.usb;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<USB> arrayList = new ArrayList<>();
        USB usbA = new Keyboard();
        USB usbB = new Mouse();
        arrayList.add(usbA);
        arrayList.add(usbB);
        Computer computer = new Computer();
        for (int i = 0; i < arrayList.size(); i++) {
            computer.connectAndLeaveUSB(arrayList.get(i));
        }
    }
}
