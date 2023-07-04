package com.geekaca.iobuffer;

import java.io.*;

public class HelloBufferStream {
    public static void main(String[] args) {
        /**
         * 缓冲流
         * copy
         */
        try (
                FileInputStream is = new FileInputStream("C:\\Users\\kanata\\Pictures\\01.png");
                FileOutputStream fos = new FileOutputStream("C:\\Users\\kanata\\Pictures\\02.png");
        ) {
            // 函数参数要求InputStream ,FileInputStream对象可以传进来，因为是前者的子类对象
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int len = -1;
            byte[] buffer = new byte[512];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
