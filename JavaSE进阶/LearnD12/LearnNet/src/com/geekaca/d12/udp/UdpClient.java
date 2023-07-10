package com.geekaca.d12.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("=====客户端启动======");
        /**
         * socket编程  -》 网络编程
         * Socket  插头
         * 水晶头  网络插头
         */
        //UDP 通信类   占据本机的6666端口  发送方
        DatagramSocket socket = new DatagramSocket(6666);
        String str = "你好，UDP";
        byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
        /**
         * 需要定义数据包
         * 邮件，包裹，信件
         */
        /**
         public DatagramPacket(byte buf[], int length,
         InetAddress address, int port)
         参数一：封装要发送的数据（包裹，邮件）
         参数二：发送数据的大小
         参数三：目的地的地址   服务端的主机IP地址
         参数四：destination 目的地 的port 服务端的端口
         */
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8888);
        //发送方
        socket.send(packet);
//        socket.receive();
    }
}
