package com.geekaca.iobuffer;

import java.io.*;

/**
 * 目标：利用字节流的复制统计各种写法形式下缓冲流的性能执行情况。
 * <p>
 * 复制流：
 * （1）使用低级的字节流按照一个一个【字节】 的形式复制文件。
 * （2）使用低级的字节流按照一个一个 【字节数组】的形式复制文件。
 * （3）使用高级的缓冲字节流按照一个一个【字节数组】的形式复制文件。
 */
public class TestBufferSpeed {
    private static final String SRC_FILE = "C:\\Users\\kanata\\Downloads\\WeChatSetup.exe";
    private static final String DEST_FILE = "C:\\Users\\kanata\\Documents\\test\\新建文件夹\\";

    public static void main(String[] args) {
        /**
         * 比较 流的效率
         */
        copyByBuffer();
        copyByByte();
        copyByByteArr();
    }

    private static void copyByBuffer() {
        long startTime = System.currentTimeMillis();
        try (
                // 1、创建低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(SRC_FILE);
                // a.把原始的字节输入流包装成高级的缓冲字节输入流
                InputStream bis = new BufferedInputStream(is);
                // 2、创建低级的字节输出流与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "bufferCopy.exe");
                // b.把字节输出流管道包装成高级的缓冲字节输出流管道
                OutputStream bos = new BufferedOutputStream(os);
        ) {

            // 3、定义一个字节数组转移数据
            //载体，搬运工具  小推车  ，车辆容量1024
            /**
             * 总共有
             * 1024
             * 1024
             * 52这么多块砖要搬运
             *
             * bis.read(buffer)   : 读取文件中剩余的字节，最大读取1024个
             *  但如果文件只剩下 52个字节可以读了 , read(buffer) 就只读到了52个字节，放入buffer
             */
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数。
            while ((len = bis.read(buffer)) != -1) {
                //卸载车
                bos.write(buffer, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用缓冲的字节流按照一个一个字节数组的形式复制文件耗时：" + (endTime - startTime)  + "ms");
    }

    private static void copyByByteArr() {
        long startTime = System.currentTimeMillis();
        try (
                // 这里面只能放置资源对象，用完会自动关闭：自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频接通
                InputStream is = new FileInputStream(SRC_FILE);
                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "byteArr.exe")
        ) {

            // 3、定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            //为什么可以不赋值
            int len; // 记录每次读取的字节数。
//            System.out.println(len);
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个一个【字节数组】的形式复制文件耗时：" + (endTime - startTime) + "ms");
    }

    /**
     * 使用低级的字节流
     * 按照一个一个字节的形式复制文件
     */
    private static void copyByByte() {
        long startTime = System.currentTimeMillis();
        try (
                // 1、创建低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(SRC_FILE);
                // 2、创建低级的字节输出流与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "bye.exe")
        ) {

            // 3、定义一个变量记录每次读取的字节（一个一个字节的复制）
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个一个字节的形式复制文件耗时：" + (endTime - startTime)  + "ms");
    }
}
