package com.geekaca.d12.tcp_threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TcpServerWithPool {
    //创建线程池  能私有的就私有
    private static ExecutorService threadPool = new ThreadPoolExecutor(10, 30,
            20, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        /**
         * 目标：用线程池 来提高资源利用率
         */
        int port = 9999;

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("server启动:" + port);
            while (true) {
                //阻塞等待client的连接   ，来一个socket连接，就创建一个socket对象指向对方
                Socket socket = serverSocket.accept();
                String cname = socket.getInetAddress().getHostAddress() + " " + socket.getPort();
                System.out.println("有人连接上了 " + cname);
                //利用线程池来分配 陪同者
                threadPool.execute(new SocketTask(socket));
            }
        } catch (IOException e) {
            System.out.println("发生异常：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
