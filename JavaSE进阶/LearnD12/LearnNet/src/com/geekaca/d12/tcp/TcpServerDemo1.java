package com.geekaca.d12.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TcpServerDemo1 {
    public static void main(String[] args) {
        int port = 7777;
        try(ServerSocket serverSocket = new ServerSocket(7777);){
            /**
             * TCP服务端
             *
             * 等别人来连接
             * 注册端口，绑定端口
             * 坐在这里等
             */
            //阻塞等待 别人连接 有连接上来了 才会继续执行 接收客户端的Socket连接请求 建立Socket通信管道
            //clientSocket 指向链接上来的客户端
            System.out.println("服务端启动：" + port);
            Socket clientSocket = serverSocket.accept();
            /**
             * 一旦连接上 后续都是I/O操作
             * 打开输入流 读取对方发送的数据
             */
            InputStream clientIps = clientSocket.getInputStream();
//            clientSocket.getOutputStream(); //获取输出
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIps));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                SocketAddress remoteSocketAddress = clientSocket.getRemoteSocketAddress();
                System.out.println(remoteSocketAddress + "对方说：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
