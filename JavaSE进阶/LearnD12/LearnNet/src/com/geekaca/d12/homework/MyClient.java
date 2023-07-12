package com.geekaca.d12.homework;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
    public static void main(String[] args) {
        try{
            //建立连接 1
            Socket socket = new Socket("127.0.0.1",6676);
            //连接到server后 立即读取对方的信息
            InputStream ips = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ips,"GBK"));
            String welcome = bufferedReader.readLine();
            System.out.println("服务器说：" + welcome);
            OutputStream ops = socket.getOutputStream();
            System.out.println("请输入：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ops,"GBK"));
            String line = null;
            while ((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
