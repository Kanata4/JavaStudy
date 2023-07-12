package com.geekaca.d12.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        //客户端 打开指向服务端的 输入流和输出流
        System.out.println("clientReader start");
        try{
            InputStream ips = socket.getInputStream();
            //4.把字节输入流包装成传冲字符输入流进行消息的接受
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            //5.按照行读取消息
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "收到了" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
