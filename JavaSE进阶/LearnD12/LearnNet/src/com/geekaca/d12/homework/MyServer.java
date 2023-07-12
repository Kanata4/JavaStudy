package com.geekaca.d12.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class MyServer {
    public static void main(String[] args) {
        try{
            int port = 6676;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动！" + port);
            //阻塞等待连接
            Socket clientSocket = serverSocket.accept();
            //有客户端链接上来 立即发送一句欢迎登录
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream,"GBK"));
            bw.write("欢迎登陆");
            bw.newLine();
            bw.flush();
            //打开字节输入流  ，为了从对方读取数据
            InputStream clientIps = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIps,"GBK"));
            String line = null;
            while((line = br.readLine()) != null){
                SocketAddress remoteSocketAddress = clientSocket.getRemoteSocketAddress();
                System.out.println(remoteSocketAddress + " 接收到的信息为：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
