package com.geekaca.d12.tcpmulti;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerMulti {
    public static void main(String[] args) {
        int port = 9999;

        try(ServerSocket serverSocket = new ServerSocket(port);){
            System.out.println("server启动：" + port);
            while(true){
                //阻塞等待client的连接 来一个socket连接 就创建一个socket对象指向对方
                /**
                 * 对这个socket的打开输入流 输出流 通信应该放在一个独立的线程中
                 * 这样不会把cpu大腿抱住不让走
                 */
                /**
                 * 大楼门口有一个保安大爷
                 * 现有情况 来一个客人 大爷要全程陪同 所以大爷做不了其他事情
                 *
                 * 目标改造 来一个客人，大爷给你分配一个陪同的人（ServerThread）
                 * 大爷支付在在门口等待
                 */
                Socket socket = serverSocket.accept();
                String cname = socket.getInetAddress().getHostAddress() + " " + socket.getPort();
                System.out.println("有人连接上了 " +  cname);
                //把链接上来的客户端socket 交给单独的线程来对接 陪同
                ServerThread serverThread = new ServerThread(socket);
                //把连接上来的客户端socket 交给单独的线程来对接，陪同
                serverThread.start();
//                String cname = socket.getInetAddress().getHostAddress() + " " + socket.getPort();
//                System.out.println("有人连接上了 " +  cname);
//                //读取客户端的信息
//                InputStream ips = socket.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(ips));
//                String str = null;
//                //这里服务端一直在等待 在这里死等 无法脱身 无法继续accept
//                while((str = br.readLine()) != null){
//                    System.out.println(cname +  "说 " + str);
//                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
