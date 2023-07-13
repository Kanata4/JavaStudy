package com.geekaca.d12.homework;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTake {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7894);
            Socket socket = serverSocket.accept();
            System.out.println("启动");
            //打开socket输入流，读取对方发来的数据 字节流
            InputStream ips = socket.getInputStream();
            //包装一层 保持数据类型的 输入流 发送方和接收方 事先约定好的格式
            DataInputStream dis = new DataInputStream(ips);
            //和发送方 顺序对应
            String name =dis.readUTF();
            int age = dis.readInt();
            double length = dis.readDouble();

            System.out.println("学生姓名：" + name + "年龄：" + age + "身高：" + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
