package com.geekaca.d09;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class HelloFile1 {
    public static void main(String[] args) {
        /**
         * File类的用法
         */
        File file = new File("C:\\Users\\kanata\\Documents\\WeChat Files\\wxid_8ds33yvi2zm522\\FileStorage\\File\\2023-06\\世界杯.txt");
        System.out.println("文件大小（字节）" + file.length());
        boolean exists = file.exists();
        System.out.println("是否存在这个文件" +  exists);

        System.out.println("是普通文件" + file.isFile());
        System.out.println("是否是文件夹" + file.isDirectory());
        //文件最后被修改的时间戳 毫秒
        long lastModifyTime = file.lastModified();
        System.out.println("最后修改时间戳" + lastModifyTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(lastModifyTime);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Date格式：" + strDate);
        System.out.println("Date格式：" + date);



        System.out.println("getPath:" );
        System.out.println();

        File myFile = new File("C:\\Users\\kanata\\Documents\\WeChat Files\\wxid_8ds33yvi2zm522\\FileStorage\\File\\2023-06");
        System.out.println(myFile.isFile());

        //Linux
        File f = new File("c" + File.separator + "Users" + File.separator + "kanata");
        //获取文件的绝对路径 从盘符根目录开始
        //相对路径 ./ 当前目录下 ../ 上层目录
        System.out.println("getAbsolutePath:" + f.getAbsolutePath());
        System.out.println(f.getName());

        System.out.println("==========");
        File curFile = new File(("./"));
        System.out.println("当前在哪个文件夹下：" + curFile.getAbsolutePath());

        //创建文件
        File f3 = new File("Hello.txt");
        try {
            boolean isCreateOk = f3.createNewFile();
            System.out.println("是否创建成功" + isCreateOk);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        f3.delete();
        File myDir = new File("./testIO");
        boolean isMkdirOk = myDir.mkdir();
        System.out.println("创建目录" + isMkdirOk);
//        myDir.delete();
        //创建多级文件夹
        File fdir = new File("./JavaSE/IO/");
        boolean isMkdirsOK = fdir.mkdirs();
        System.out.println(isMkdirsOK);
    }
}
