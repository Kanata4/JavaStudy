package com.geekaca.d4.d2_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateParse {
    public static void main(String[] args) {
        /**
         * String -> Date
         */
        String dateStr = "2023年06月20日 11:12:51";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //Unhandled exception: java.text.ParseException 未捕获的异常
        try {
            Date date = sdf.parse(dateStr);
            System.out.println("解析后的日期：" + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
