package com.geekaca.iobuffer.homework;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        /**
         * 在指定文件夹下 名字搜索 是否包含指定内容
         * BufferedReader
         * 递归 要有终点
         */
        File fileDir = new File("D:\\dev\\workspace\\java-lh\\JavaSE进阶\\IOBuffer");
        searchFile(fileDir,"HelloFileReader1.java");
    }

    /**
     *
     * @param dir
     * @param toSearchName
     */
    public static void searchFile(File dir, String toSearchName) throws IOException {
        File[] files = dir.listFiles();
        if (files != null && files.length > 0){
            //文件夹下有文件
            for (File file:files) {
                if (file.isFile()){
                    //todo:遇到文件就判断名字
                    if (file.getName().contains(toSearchName)){
                        System.out.println("找到了" + file.getAbsolutePath());
                        FileReader fr = new FileReader(file.getAbsolutePath());
                        BufferedReader br = new BufferedReader(fr);
                        String line = null;
                        //不等于null说明还有更多内容可以读取
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    }
                } else if(file.isDirectory()) {
                    searchFile(file,toSearchName);
                }
            }
        }
    }
}
