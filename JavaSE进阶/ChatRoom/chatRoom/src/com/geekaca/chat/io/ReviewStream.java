package com.geekaca.chat.io;

import java.io.*;

public class ReviewStream {
    public static void main(String[] args) {
        /**
         * 字节缓冲流的读取和写出
         */
        File file = new File("C:\\Users\\kanata\\Pictures\\01.png");
        File file2 = new File("C:\\Users\\kanata\\Pictures\\01copy.png");
        if (file.exists()){
            try(FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(file2);){
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                byte[] buf = new byte[1024];
                int len = 1;
                while ((bis.read(buf))!= -1){
                    bos.write(buf,0,len);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
