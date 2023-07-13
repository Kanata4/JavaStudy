package com.geekaca.d12.homework;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestSend {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7894);
            //打开输出流 向对方发送数据 Stream字节流
            OutputStream ops = socket.getOutputStream();
            //包装一层
            DataOutputStream dos = new DataOutputStream(ops);
            /**
             * 向dos写出数据时 就会写出到底层的socket输出流
             *
             * 也就是发送给对方(ServerSocket)
             */
            dos.writeUTF("张维");
            dos.writeInt(24);
            dos.writeDouble(183);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
