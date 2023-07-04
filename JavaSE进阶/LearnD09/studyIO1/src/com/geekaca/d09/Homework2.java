package com.geekaca.d09;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Homework2 {
    public static void main(String[] args) {
        /**
         * 搜索文件并复制到新的文件夹
         *
         * 找到一个png，就要复制一个文件过去
         */
        File fileDir = new File("D:\\dev\\workspace\\java-lh\\JavaSE进阶\\LearnD09\\studyIO1");
        System.out.println(fileDir.getAbsolutePath());
        File toFile = new File("C:\\Users\\kanata\\Pictures\\01.png");
        searchFile(fileDir, ".png", toFile);
    }

    /**
     * @param dir          在哪个目录中搜索   File 引用类型 null
     * @param toSearchName 要搜索的文件名字  模糊搜索
     * @param targetDir    目标目录
     */
    public static void searchFile(File dir, String toSearchName, File targetDir) {
        if (dir != null && dir.isDirectory()) {
            //空指针异常 保护   短路与   只要前半部分是false，那么 &&后面不会执行
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                //文件夹下有文件
                for (File file : files) {
                    if (file.isFile()) {
                        //todo: 遇到文件就判断名字
                        if (file.getName().contains(toSearchName)) {
                            System.out.println("找到了：" + file.getAbsolutePath());
                            copyFileToDir(file, targetDir);
                        }
                    } else if (file.isDirectory()) {
                        //如果是当前file也指向一个目录   递归  ，因为此处有终点
                        searchFile(file, toSearchName, targetDir);
                    }
                }
            }
        }
    }

    /**
     *  文件复制
     * @param srcFile 原始文件
     * @param targetDir 目标目录
     */
    public static void copyFileToDir(File srcFile, File targetDir){
        /**
         * 把复杂问题拆分成小的部分
         * 然后分别解决
         * todo: 把当前的这个png文件内容 复制到 目标目录下
         * 手头有： file targetDir
         * 问题转变为  如何把file对象指向的文件内容 复制到目标目录下
         * 一方面读取原始文件内容
         * 一方面 写出到目标文件
         * 封装方法
         * 输入参数 file targetDir
         * 返回值 void
         */
        //需要构造一个File对象，指向目标文件
        // C:\Users\ytdag\Documents\myPngs\a.png
        File targetFile = new File(targetDir.getAbsolutePath() + File.separator + srcFile.getName());
        try (
                InputStream fis = new FileInputStream(srcFile);
                OutputStream fos = new FileOutputStream(targetFile);
        ) {
            //读取文件内容，写出到目标文件
            int len = -1;
            byte[] buffer = new byte[512];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制完成 :" + targetFile.getAbsolutePath());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
