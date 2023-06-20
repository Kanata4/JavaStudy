package com.geekaca.d4.homework;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Test04 {
    public static void main(String[] args) {
        /**
         * 从现在开始，每隔23天输出一下日期，输出5次
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < 5; i++) {
            LocalDateTime plus = localDateTime.plusDays(23);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatedStr = dtf.format(plus);
            System.out.println(formatedStr);
        }
    }
}
