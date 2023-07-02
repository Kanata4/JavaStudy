package com.geekaca.d09;

import java.io.File;

public class TestFileSearch {
    public static void main(String[] args) {
        /**
         * 递归方式文件搜索
         * 根据文件名在目录下递归的搜索
         * 遇到文件的就判断名字
         * 遇到文件夹 就递归搜索
         */
        searchFile(new File("D:\\dev"),"Hello.txt");
    }

    /**
     * @param dir          在哪个目录中搜索
     * @param toSearchName 要搜索的文件名字
     */
    public static void searchFile(File dir, String toSearchName) {
        //1.判断目录是否为空 是否是目录
        if (dir != null && dir.isDirectory()) {
            //提取但钱目录下的一级文件
            File[] files = dir.listFiles();
            //判断是否存在一级文件对象 判断目录是否不为空
            if (files != null && files.length > 0) {
                //文件夹下有文件
                for (File file : files) {
                    if (file.isFile()) {
                        //todo：遇到文件就判断名字
                        if (file.getName().contains(toSearchName)){
                            System.out.println(file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        //如果是当前file也指向一个目录
                        searchFile(file, toSearchName);
                    }
                }
            }
        }
    }
}
