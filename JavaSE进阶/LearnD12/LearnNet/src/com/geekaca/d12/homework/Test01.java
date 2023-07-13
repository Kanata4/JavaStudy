package com.geekaca.d12.homework;

import java.io.*;

public class Test01 {
    private static String path = "C:\\Users\\kanata\\Documents\\dataOut.txt";

    public static void main(String[] args) {
        //向文件写出能力 字节流
        /**
         * 带有数据类型的写出 DataOutputStream
         * 不保证可读性！！！
         */
        try{
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("张维");
            dos.writeInt(24);
            dos.writeDouble(183.5);
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        read();

    }

    public static void read(){
        try{
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            //顺序和写出的时候 对应
            String name = dis.readUTF();
            int age = dis.readInt();
            double height = dis.readDouble();
            System.out.println("姓名：" + name + "年龄：" + age + "身高：" + height);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


