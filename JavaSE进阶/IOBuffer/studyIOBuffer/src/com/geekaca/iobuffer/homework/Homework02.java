package com.geekaca.iobuffer.homework;

import java.io.*;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        /**
         * 文本文件内容的搜索
         * FileReader
         * BufferedReader 字符缓冲输入流 按照行读取
         */
        readFile();
    }

    public static void readFile() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\kanata\\Documents\\test\\1.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        //不等于null说明还有更多内容可以读取
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
