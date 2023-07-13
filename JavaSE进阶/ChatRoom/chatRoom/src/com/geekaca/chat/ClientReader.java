package com.geekaca.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientReader implements Runnable{
    private Socket socket;
    private ClientChat clientChat;

    public ClientReader(Socket socket, ClientChat clientChat) {
        this.socket = socket;
        this.clientChat = clientChat;
    }

    @Override
    public void run() {
        try {
            InputStream ips = socket.getInputStream();
            OutputStream ops = socket.getOutputStream();
            /**
             * 输入流 用来从对方（ServerSocket）读取信息
             */
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true){
                /** 读取当前的消息类型 ： 登录 群发 私聊 @消息*/
                int msgType = dis.readInt();
                switch (msgType){
                    case ChatConstants.MSG_TYPE_LOGIN:
                        //来自服务端的广播 有人登陆
                        String allNickName = dis.readUTF();
                        String[] allNickNames = allNickName.split(ChatConstants.SPILIT);
                        /**
                         * UI  展示到在线人数的界面
                         * 刷新界面的在线用户展示
                         */
                        clientChat.onLineUsersList.setListData(allNickNames);
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
            e.printStackTrace();
        }
    }
}
