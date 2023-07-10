package com.geekaca.d12.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class MyServer {
    public static void main(String[] args) {
        try{
            int port = 6676;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动！" + port);
            Socket clientSocket = serverSocket.accept();
            InputStream clientIps = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIps));
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
