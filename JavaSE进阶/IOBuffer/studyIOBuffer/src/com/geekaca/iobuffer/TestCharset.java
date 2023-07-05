package com.geekaca.iobuffer;

import java.io.*;

public class TestCharset {
    public static void main(String[] args) {
        /**
         * 了解
         * 代码和要读取的文件编码不一致
         *
         * .txt 用的编码格式 是GB18030  中文编码的一种
         * java代码用的编码是UTF-8
         */
        readFile();
        System.out.println("=================");
        testStreamReader();
        testInput();
    }
    //乱码问题
    public static void readFile(){
        try (FileReader fr = new FileReader("writer.txt");) {
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Java代码是UTF-8编码
     * .txt 是GB18030编码
     */
    public static void testStreamReader() {

        try (
                InputStream is = new FileInputStream("writer.txt");
                //电源转接头   把原始的字节流 转换冲字符流，
                //用指定的编码（经过转接，解决两边编码不一致 导致的乱码问题）
                //GB18030 和.txt的编码对应
                InputStreamReader isr = new InputStreamReader(is, "GB18030");
        ) {
            BufferedReader br = new BufferedReader(isr);
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输入了: "+ s);
    }
}

