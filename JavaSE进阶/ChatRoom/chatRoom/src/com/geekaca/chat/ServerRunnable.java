package com.geekaca.chat;

import java.io.*;
import java.net.Socket;
import java.util.Collection;

public class ServerRunnable implements Runnable{
    private Socket clientSocket;

    public ServerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try(InputStream ips = clientSocket.getInputStream();
        OutputStream ops = clientSocket.getOutputStream();
            DataInputStream dis= new DataInputStream(new DataInputStream(ips));
        ) {
            while (true) {
                int msgType = dis.readInt();
                switch (msgType){
                    case ChatConstants.MSG_TYPE_LOGIN:
                        //登陆消息
                        String nickName = dis.readUTF();
                        System.out.println("login：" + clientSocket.getRemoteSocketAddress() + "nick：" + nickName);
                        ServerChat.onLineSocketMap.put(clientSocket,nickName);
                        //广播一遍
                        /**
                         * 1.拿到所有人的昵称
                         * 发出去 消息类型
                         */
                        StringBuilder stringBuilder = new StringBuilder();
                        Collection<String> userNicknames = ServerChat.onLineSocketMap.values();
                        for (String name : userNicknames){
                            stringBuilder.append(name + ChatConstants.SPILIT);
                        }
                        //去掉最后一个分隔符
                        stringBuilder.substring(0,stringBuilder.lastIndexOf(ChatConstants.SPILIT));
                        sendMsgToAll(stringBuilder.toString());
                        break;
                    case ChatConstants.MSG_TYPE_CHAT:
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     *
     * @param msg 一长串的用户昵称 连接在一起的
     */
    private void sendMsgToAll(String msg){
        ServerChat.onLineSocketMap.forEach((socket,nick)-> {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //有人登录 广播所有人的名字
                dos.writeInt(ChatConstants.MSG_TYPE_LOGIN);
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
