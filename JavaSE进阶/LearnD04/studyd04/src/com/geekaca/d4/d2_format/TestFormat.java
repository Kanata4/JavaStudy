package com.geekaca.d4.d2_format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFormat {
    public static void main(String[] args) {
        /**
         * 日期格式化
         *
         * Date  -> String
         */
        Date date = new Date();
        // 2、格式化这个日期对象 (指定最终格式化的形式)
        /**
         * y year
         * M Month
         * d day
         * H Hour
         * m minute
         * s second
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String formated = sdf.format(date);
        System.out.println(formated);
        // 格式化时间戳  毫秒
        long curTime = System.currentTimeMillis();
        // 125毫秒后 是什么时间？
        curTime += 125;
        String formatedTimeStr = sdf.format(curTime);
        System.out.println("125ms后是： " + formatedTimeStr);

        System.out.println("================");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
        String formatStr3 = sdf2.format(new Date());
        System.out.println(formatStr3);
    }
}
