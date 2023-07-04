package com.geekaca.iobuffer;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloReaderWriter {
    public static void main(String[] args) {
        /**
         * 字符缓冲流！！！
         */
//        testBufferedWriter();
        //从字符串中查找 单词
        String str = "Java Hello main class file";
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);
        //找到一个符合条件的
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }

    public static void testBufferedReader() {
        try (
                Reader fr = new FileReader("test.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
            //读取一行
//            String s = br.readLine();
//            System.out.println(s);
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());//当没有内容可读后，返回null
            String line = null;
            //不等于null说明还有更多内容可以读取
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testBufferedWriter() {
        try (Writer fw = new FileWriter("writer.txt");) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("hello");
            bw.newLine();//加入和换行符
            bw.write("测试");
            for (int i = 0; i < 10; i++) {
                bw.write("你好" + i);
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
