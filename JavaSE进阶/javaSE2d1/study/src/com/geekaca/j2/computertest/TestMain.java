package com.geekaca.j2.computertest;

public class TestMain {
    public static void main(String[] args) {
        USB usbA = new Keyboard();
        USB usbB = new Mouse();

        Computer computer = new Computer();
        computer.connectAndLeaveUSB(usbA);
    }
}
