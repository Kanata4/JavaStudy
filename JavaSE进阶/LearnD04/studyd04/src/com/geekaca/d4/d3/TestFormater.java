package com.geekaca.d4.d3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestFormater {
    public static void main(String[] args) {
        /**
         * SimpleDateFormate Date 组合
         * DateTimeFormatter 格式化 LocalDateTime
         */
        //LocalDateTime -> String
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedStr = dtf.format(nowDateTime);
        System.out.println(formatedStr);

        //只要年
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy");
        String formatYear = dtf2.format(LocalDateTime.now());
        System.out.println(formatYear);

        //String -> LocalDateTime
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parseDateTime = LocalDateTime.parse("2003-01-01 12:00:00",dtf3);
        System.out.println("用户从界面录入的日期是一年中的第几天：" + parseDateTime.getDayOfYear());
    }


}
