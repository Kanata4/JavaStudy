package com.geekaca.d12.tcp_threadpool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTask implements Runnable{
    private Socket socket;

    public SocketTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取客户端的ip 和端口
        String cname = socket.getInetAddress().getHostAddress() + " " + socket.getPort();
        try {
            InputStream ips = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            /**
             * 服务端 可以收到每个客户端发的消息
             * 服务端还可以打开每个客户端的输出流，向每个客户端发送消息
             *
             * 如何实现 ，一个客户端发消息，多个客户端都能收到，类似于公共聊天室
             */
            String s = null;
            //不断的读取对方的数据
            while ((s = br.readLine()) != null) {
                System.out.println(cname + " : " + s);
            }
        } catch (IOException e) {
            System.out.println(" socket异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
