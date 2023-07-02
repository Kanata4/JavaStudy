package com.geekaca.d09;

import java.io.File;
import java.util.Arrays;

public class TestDir2 {
    public static void main(String[] args) {
        /**
         * 如何遍历文件夹
         */

        File file = new File("D:\\dev\\study\\JavaSE进阶\\LearnD09");
        String[] listFileNames = file.list();
//        for (int i = 0; i < listFileNames.length; i++) {
//            System.out.println(listFileNames[i]);
//        }
        //数组中放的 都是File类型的对象
        File[] fileArr = file.listFiles();
        for (int i = 0; i < fileArr.length; i++) {
            File file1 = fileArr[i];
            System.out.print(file1.getName());
            System.out.print(" " + (file1.isFile() ? "是文件" : ""));
            System.out.print(" " + (file1.isDirectory() ? "是文件夹" : ""));
            System.out.println();
        }
        File dir2 = new File("./testIO");
        File[] files = dir2.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
