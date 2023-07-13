package com.geekaca.chat;


public class ChatConstants {
    public static final int PORT = 7983;

    /**
     * 用户登录
     * 客户端发给server 实现登录
     * server广播给每个客户端 通知有人登录
     * 1 昵称
     */
    public static final int MSG_TYPE_LOGIN = 1;
    /**
     * 大厅的聊天
     */
    public static final int MSG_TYPE_CHAT = 2;
    /**
     * 协议分隔符
     * 自定义
     * Tom
     */
    public static final String SPILIT = "003197♣♣④④♣";
}
