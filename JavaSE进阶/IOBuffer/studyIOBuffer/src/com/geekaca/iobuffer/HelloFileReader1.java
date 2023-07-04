package com.geekaca.iobuffer;

import java.io.*;

public class HelloFileReader1 {
    public static void main(String[] args) {
        /**
         * FileReader文件 字符输入流
         * ctrl +q 查看构造器
         */
        try(
            Reader freader = new FileReader(new File("test.txt"));
        ) {
            //只读取一个字符
//            int read = freader.read();
//            System.out.println((char) read);
            //记住 固定步骤
            int len = -1;
            char[] charArr = new char[16];
            while( (len = freader.read(charArr)) != -1){
                System.out.println(new String(charArr, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
