package com.geekaca.d12;

import java.io.*;

public class Demo {
    private static String path = "C:\\Users\\kanata\\Documents\\dataOut.txt";
    public static void main(String[] args) {
        /**
         *  自定义的消息格式
         *
         *  把数据，信息写出到文件
         */
//        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeInt(9);
//            dos.writeUTF("你好");
//            dos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        read();
    }

    public static void read(){
        try {
            FileInputStream fis = new FileInputStream(path);
            //可以 把DataInputStream 指向 socket 的输入流
            DataInputStream dis = new DataInputStream(fis);
            //写的时候的顺序，和读的顺序对应
            int i = dis.readInt();
            String str = dis.readUTF();
            System.out.println(i);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
