package com.geekaca.d4.d3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;


public class TestUpdateDateTime {
    public static void main(String[] args) {
        /**
         * 修改日期时间
         */
        LocalDateTime curDateTime = LocalDateTime.now();
        //每次修改都会创建一个新的对象 原本的不可修改 Shift + F6 重新命名
        LocalDateTime nextDateTime = curDateTime.plusDays(52);
        System.out.println("52天之后是:" + nextDateTime);

        LocalDateTime dateTime500 = curDateTime.plusYears(500);
        System.out.println("500年后：" + dateTime500);

        LocalDateTime dateTime3000Before = curDateTime.minusDays(3000);
        beforeAfter();
        LocalDateTime localDateTime = LocalDateTime.now();
        //报错
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(49);
        System.out.println("月中的第49天：" + localDateTime1);


    }
    public static void updateDate() {
        LocalDate date = LocalDate.now();
        //会创建新的对象
        System.out.println(date.plusYears(20));

        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime.plusSeconds(190));
    }
    public static void panduan(){
        LocalDate myBirthday = LocalDate.of(1980,5,4);
        LocalDate now = LocalDate.now();
        boolean isMyBirthday = now.equals(myBirthday);

        int monthValue = myBirthday.getMonthValue();
        int dayOfMonth = myBirthday.getDayOfMonth();
        if (now.getDayOfMonth() == dayOfMonth && monthValue == now.getMonthValue()){
            System.out.println("是你的生日");
        } else{
            System.out.println("不是生日");
        }
        /**
         * 历史上的今天
         * 06-20
         * Map
         */
    }
    public static void beforeAfter(){
        LocalDate myDate = LocalDate.of(2019,12,12);
        LocalDate nowDate = LocalDate.now();
        //今天是否是2019-12-12
        boolean isTheDate = nowDate.equals(myDate);
        System.out.println("今天是在" + myDate + "之前？" + nowDate.isBefore(myDate));
        System.out.println("今天是在" + myDate + "之前？" + nowDate.isAfter(myDate));
        //判断是否是你的生日
        LocalDate birthDay = LocalDate.of(1999,5,5);
        LocalDate nowDate2 = LocalDate.now();

        MonthDay myBirth = MonthDay.of(birthDay.getMonthValue(),birthDay.getDayOfMonth());
        MonthDay nowMd = MonthDay.of(nowDate2.getMonthValue(),nowDate2.getDayOfMonth());
        //ctrl + alt + 点击 进入方法的实现
        System.out.println("今天是否是你的生日" + myBirth.equals(nowMd));
    }
}
