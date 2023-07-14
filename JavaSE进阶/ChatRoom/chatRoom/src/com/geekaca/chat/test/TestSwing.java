package com.geekaca.chat.test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TestSwing {
    public static void main(String[] args) {
        /**
         * 了解Swing搭建用户界面
         */
//        TestSwing testSwing = new TestSwing();
//        testSwing.init();
        MyFrame myFrame = new MyFrame();
//        String str = "tom@@@jack@@@i";
//        String[] splitedStr = str.split("@@@");
//        System.out.println(Arrays.toString(splitedStr));
    }

    public void init(){
        JFrame jFrame = new JFrame("hello 窗口");
        jFrame.setBackground(Color.BLUE);
        jFrame.setBounds(377,377,300,200);
        jFrame.setVisible(true);

        JLabel myLabel = new JLabel("你好 界面标签");
        jFrame.add(myLabel);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
