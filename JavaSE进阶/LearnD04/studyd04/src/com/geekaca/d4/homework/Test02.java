package com.geekaca.d4.homework;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test02 {
    public static void main(String[] args) {
        /**
         * 设计一个函数，参数是两个字符串 开始时间和结束时间
         * 计算 返回 相差多少秒
         */
        String startTime = "2003-01-01 12:00:00";
        String endTime = "2003-06-20 23:00:00";
        System.out.println("相差了：" + TestCount(startTime,endTime) + "秒");
    }
    public static long TestCount(String startTime,String endTime){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parseDateTime = LocalDateTime.parse(startTime,dtf);
        LocalDateTime parseDateTime2 = LocalDateTime.parse(endTime,dtf);
        Duration duration = Duration.between(parseDateTime,parseDateTime2);
        long seconds = duration.toSeconds();
        return seconds;
    }
}
