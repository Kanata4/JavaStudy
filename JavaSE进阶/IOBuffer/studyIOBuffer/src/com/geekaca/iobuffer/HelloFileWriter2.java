package com.geekaca.iobuffer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HelloFileWriter2 {
    public static void main(String[] args) {
        /**
         * 文件  字符输出流
         * 适合文字信息的写出
         */
        char[] arr = {'C', 'D'};
        try (
                Writer fwriter = new FileWriter(new File("C:\\Users\\kanata\\Documents\\test\\1.txt"), true);
        ) {
            fwriter.write("\r\n");
            fwriter.write('A');
            fwriter.write("中国");
            fwriter.write(arr);

            //只写前三个字符
            fwriter.write("1234567", 0, 3);
            //把内容写出到磁盘
            fwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
