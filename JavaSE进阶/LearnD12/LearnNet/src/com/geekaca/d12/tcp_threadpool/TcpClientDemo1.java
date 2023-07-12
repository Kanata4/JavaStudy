package com.geekaca.d12.tcp_threadpool;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClientDemo1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);

            OutputStream ops = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(ops);
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("请输入信息：");
                String next = scan.next();
                pw.println(next);
                pw.flush();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
