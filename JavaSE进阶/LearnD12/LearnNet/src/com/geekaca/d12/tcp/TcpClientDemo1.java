package com.geekaca.d12.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TcpClientDemo1 {
    public static void main(String[] args) {
        try {
            //客户端指定了 目标服务器的ip和端口 没有指定自己要占用的端口，由电脑随机分配
            //1.建立连接
            Socket socket = new Socket("192.168.3.118",7777);
            //2.打开输出流 负责向对方发送数据 向外发，输出流
            OutputStream ops = socket.getOutputStream();
            PrintStream ps = new PrintStream(ops);
            ps.println(" 你好，我是TCP客户端");
            ps.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
