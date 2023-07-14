package com.geekaca.chat;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ServerRunnable implements Runnable {
    /**
     * 指向当前连接的对方socket(客户端socket)
     * 引用类型
     */
    private Socket clientSocket;

    public ServerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream ips = clientSocket.getInputStream();
             OutputStream ops = clientSocket.getOutputStream();
             //打开输入流，读取对方数据
             DataInputStream dis = new DataInputStream(ips);
        ) {
            while (true) {
                //不断读取对方的消息
                //判断消息类型
                int msgType = dis.readInt();
                switch (msgType) {
                    case ChatConstants.MSG_TYPE_LOGIN:
                        //登陆消息
                        String nickName = dis.readUTF();
                        System.out.println("login : " + clientSocket.getRemoteSocketAddress() + " nick:" + nickName);
                        ServerChat.onLineSocketMap.put(clientSocket, nickName);
                        //广播一遍，当前房间，大厅 所有人名字
                        /**
                         * 1, 拿到所有人的昵称
                         * 2，发出去  消息类型  1
                         */
                        StringBuilder stringBuilder = new StringBuilder();
                        //取出 map中的所有values
                        Collection<String> userNicknames = ServerChat.onLineSocketMap.values();
                        for (String name : userNicknames) {
                            stringBuilder.append(name + ChatConstants.SPILIT);
                        }
                        //去掉最后一个分隔符
                        stringBuilder.substring(0, stringBuilder.lastIndexOf(ChatConstants.SPILIT));
                        sendMsgToAll(stringBuilder.toString());
                        break;
                    case ChatConstants.MSG_TYPE_CHAT:
                        //聊天消息
                        String msgContent = dis.readUTF();
                        //获取是谁发的消息   昵称
                        String userNickName = ServerChat.onLineSocketMap.get(clientSocket);
                        System.out.println("昵称：" + userNickName + ":" + msgContent);
                        //把收到的消息广播发给每个客户端socket
                        //格式：Tom： hello 2023-07-14 12：09：09
                        StringBuilder toSendMsg = new StringBuilder();
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        toSendMsg.append(now.format(dtf)).append("  ").append(userNickName).append("  ")
                        .append("\n" + msgContent).append("\n");
                        System.out.println("sendMsgToOther： " + toSendMsg);
                        sendMsgToOther(toSendMsg.toString());
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("发生异常" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 广播
     * 把房间内所有人昵称 发送给所有人
     * 循环访问每一个socket，发出信息
     * @param msg  一长串的用户昵称连接在一起
     * @throws Exception
     */
    private void sendMsgToAll(String msg) {
        //key  socket    value: 昵称
        ServerChat.onLineSocketMap.forEach((socket, nick) -> {
            try {
                //带有数据类型（类似发送一根竹子，上面顺序刻着 不同的符号，代表不同含义）  发送消息
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                //有人登陆，广播所有人的名字
                //首先刻一个1  代表  告诉客户端   当前房间都有谁
                dos.writeInt(ChatConstants.MSG_TYPE_LOGIN);
                //房间内所有昵称 一长串连接
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * 别的客户端  接受 别的客户端 的消息 服务端已经接收到了
     * 昵称 内容 时间
     * 昵称: K V map.get
     * 内容：msgContent dis.readUTF()
     * 时间：LocalDateTime
     */
    private void sendMsgToOther(String msg){
        ServerChat.onLineSocketMap.forEach((socket, nick) -> {
            try {
                //写入输出流 将内容发送给客户端的输入流
                //带有数据类型（类似发送一根竹子，上面顺序刻着 不同的符号，代表不同含义）  发送消息
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(ChatConstants.MSG_TYPE_CHAT);
                //房间内所有昵称 一长串连接
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
