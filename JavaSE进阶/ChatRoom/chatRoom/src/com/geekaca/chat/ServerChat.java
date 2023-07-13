package com.geekaca.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务端
 */
public class ServerChat {

    /**
     * 定义一个集合存放所有在线的socket
     *
     * 当客户端 登陆上来（带着昵称）之后，server端需要把昵称和对应的socket 存起来
     * key:客户端socket对象
     * value:相对应的昵称
     * socket1：zhangsan
     * socket2：Tom
     * socket3：Jack
     */
    public static Map<Socket,String> onLineSocketMap = new HashMap<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(ChatConstants.PORT);
            System.out.println("ServerSocket 启动 port：" + ChatConstants.PORT);
            while(true) {
                Socket clientSocket = serverSocket.accept();
                //分配导游
                ServerRunnable serverRunnable = new ServerRunnable(clientSocket);
                new Thread(serverRunnable).start();
            }
        } catch (IOException e) {
            System.out.println(" 发生异常 "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
