package com.geekaca.d09;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Homework1 {
    public static void main(String[] args) {
        File fileDir = new File("D:\\dev\\workspace\\java-lh\\JavaSE进阶\\LearnD09\\studyIO1");
        File toFile = new File("D:\\dev\\workspace\\java-lh\\hello.txt");
        searchFile(fileDir, ".java", toFile);
    }

    /**
     * @param dir          在哪个目录中搜索   File 引用类型 null
     * @param toSearchName 要搜索的文件名字  模糊搜索
     * @param outFile      要把找到的文件名字和路径写出到哪个文件中去
     */
    public static void searchFile(File dir, String toSearchName, File outFile) {
        if (dir != null && dir.isDirectory()) {
            //空指针异常 保护   短路与   只要前半部分是false，那么 &&后面不会执行
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                try (
                        OutputStream fos = new FileOutputStream(outFile, true);
                ) {
                    //文件夹下有文件
                    for (File file : files) {
                        if (file.isFile()) {
                            //todo: 遇到文件就判断名字  Hello.java
                            if (file.getName().contains(toSearchName)) {
                                System.out.println("找到了：" + file.getAbsolutePath());
                                /**
                                 * 手头有： 文件对象File
                                 * 要做的：
                                 * 向 outFile中写出 找到的文件名和完整路径
                                 * Hello.java    C:\\test/hello/Hello.java
                                 * 把字符串写进目标目标文件
                                 */
                                String fname = file.getName();
                                String absolutePath = file.getAbsolutePath();
                                fos.write(fname.getBytes(StandardCharsets.UTF_8));
                                fos.write(" ".getBytes(StandardCharsets.UTF_8));
                                fos.write(absolutePath.getBytes(StandardCharsets.UTF_8));
                                fos.write("\r\n".getBytes(StandardCharsets.UTF_8));//换行
                                fos.flush();
                            }
                        } else if (file.isDirectory()) {
                            //如果是当前file也指向一个目录   递归  ，因为此处有终点
                            searchFile(file, toSearchName, outFile);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
