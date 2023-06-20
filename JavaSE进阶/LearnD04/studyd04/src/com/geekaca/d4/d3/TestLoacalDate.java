package com.geekaca.d4.d3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestLoacalDate {
    public static void main(String[] args) {
        testTime();
    }

    public static void testTime(){
        /**
         * LocalTime
         */
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
        int hour = nowTime.getHour();
        int minute = nowTime.getMinute();
        int second = nowTime.getSecond();
        int nano = nowTime.getNano();//纳秒 1s = 1000ms 1ms = 1000微秒 1微秒=1000纳秒
        //利用指定的时间构造一个LocalTime
        LocalTime timeMy = LocalTime.of(14, 52);
        System.out.println(timeMy);

        //LoacalDateTime
        //构造一个指定的日期时间对象
        LocalDateTime mytime1 = LocalDateTime.of(2023,6,20,14,53,12);
        System.out.println(mytime1);
    }

    public static void testDate(){
        /**
         *  LocalDate
         */
        LocalDate nowDate = LocalDate.now();
        System.out.println("当前日期：" + nowDate);
        System.out.println("year:" + nowDate.getYear());
        int month = nowDate.getMonthValue();
        int day = nowDate.getDayOfMonth();

        int dayOfYear = nowDate.getDayOfYear();

        System.out.println(nowDate.getDayOfWeek().getValue());

        System.out.println("构造一个指定的时间");
        LocalDate myBirthday = LocalDate.of(1980,5,4);
        System.out.println(myBirthday);
    }
}
