package com.geekaca.iobuffer.homework;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        /**
         * 字节流 实现视频文件的复制
         * 从一个文件夹到另一个文件夹
         * FilePutStream FileOutputStream
         * BufferedInputStream/BufferedOutputStream
         */
        copyVide();
    }

    public static void copyVide() throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("C:\\Users\\kanata\\Downloads\\180419_Boxing_20_18.mp4");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\kanata\\Documents\\test\\180419_Boxing_20_18.mp4");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //复制
//        int by;//记录每次读取的字节数
        //字节数组当作载体 效率更高
        int len = -1;
        byte[] buffer = new byte[512];
        while((len = bis.read(buffer))!=-1){        //传参
            bos.write(buffer,0,len);
        }
        bis.close();
        bos.close();
    }
}
