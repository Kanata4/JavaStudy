package com.geekaca.d12.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024 * 64];// 64k
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("等待数据");
        //接收方
        socket.receive(packet);
        System.out.println("收到数据----");
        //实际收到的包的大小
        int length = packet.getLength();
        String receivedStr = new String(buffer, 0, length);
        //打印发送方的信息
        System.out.println("发送方的IP："+packet.getSocketAddress() + " 发送方的port："+ packet.getPort());
        System.out.println("收到了：" + receivedStr);
//        socket.send();
    }
}
