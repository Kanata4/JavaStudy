package com.geekaca.d4.homework;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class Test03 {
    public static void main(String[] args) {
        /**
         * 计算2023年有多少个星期二
         */
        int year = 2023;
        LocalDate localDate = LocalDate.of(year,Month.JANUARY,1);
        LocalDate tuesday = localDate.with(firstInMonth(DayOfWeek.TUESDAY));
        int count = 0;
        while (tuesday.getYear() == year){
            tuesday = tuesday.plus(Period.ofDays(7));
//            System.out.println(tuesday);
            count++;
        }
        System.out.println(year + "年有" + count + "个星期二");
    }
}
