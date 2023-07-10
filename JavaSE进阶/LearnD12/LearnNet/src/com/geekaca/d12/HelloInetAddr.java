package com.geekaca.d12;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HelloInetAddr {
    public static void main(String[] args) {
        /**
         * 地址相关类
         */
        try {
            InetAddress localHostAddr = InetAddress.getLocalHost();
            //主机名
            System.out.println("hostName:" + localHostAddr.getHostName());
            //电脑的IP地址
            System.out.println("hostAddr:" + localHostAddr.getHostAddress());

            InetAddress bdAddr = InetAddress.getByName("www.baidu.com");
            System.out.println("baidu hostName:" + bdAddr.getHostName());
            //根据域名 获取ip
            System.out.println("baidu IP:" + bdAddr.getHostAddress());

            //ping功能
            byte[] ipBytes = {(byte)192, (byte)168, 10, 1};
            InetAddress byAddress = InetAddress.getByAddress(ipBytes);
            boolean isReachable = byAddress.isReachable(3000);//ping  超时时间 3000毫秒
            System.out.println("ping 192.168.1.1 是否畅通： " + isReachable);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
