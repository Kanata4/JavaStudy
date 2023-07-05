package com.geekaca.iobuffer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class TestCommonsIO {
    public static void main(String[] args) {
        /**
         * 学习commons-io库
         */
        //1, 文件的复制   pdf文件 是字节流文件
//        try (
//                FileInputStream fis = new FileInputStream("C:\\Users\\ytdag\\OneDrive - 株式会社GeekAca\\Course_Java_Japaneses_Overseas\\JAVA\\Java0520\\2 JavaSE进阶\\source\\d10 IO流2(重要)\\7-4 IO2 缓冲流.pdf");
//                FileOutputStream fos = new FileOutputStream("C:\\dev\\tmp\\7-5buffer.pdf");
//
//        ) {
//            IOUtils.copy(fis, fos);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //2.完成文件复制到某个文件夹下！
//        try {
//            FileUtils.copyFileToDirectory(new File("C:\\dev\\tmp\\7-5buffer.pdf"), new File("C:\\dev\\tmp\\test"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 3.完成文件夹复制到某个文件夹下
        try {
            FileUtils.copyDirectoryToDirectory(new File("C:\\Users\\kanata\\Documents\\test"), new File("D:\\dev\\tools"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
