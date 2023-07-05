package com.geekaca.iobuffer;

import java.io.*;

public class TestStreamWriter {
    public static void main(String[] args) {
        /**
         * 字符转换输出流
         */
        try(OutputStream ops = new FileOutputStream("streamWriter.txt");) {
            Writer osw = new OutputStreamWriter(ops, "GBK");
            osw.write("中国人");
            osw.write("中国人");
            osw.write("中国人");
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
