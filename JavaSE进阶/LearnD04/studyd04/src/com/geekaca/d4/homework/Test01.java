package com.geekaca.d4.homework;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test01 {
    public static void main(String[] args) {
        /**
         * 计算1997-10-01到今天有多少天
         */
        // 本地日期时间对象。
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        // 1997-10-01
        LocalDateTime date1 = LocalDateTime.of(1997, 10
                , 01, 00, 00, 00);
        Duration duration = Duration.between(date1,today);
        long days = duration.toDays();
        long seconds = duration.toSeconds();
        System.out.println("从1997-10-01到今天有： " + days + "天");
        System.out.println("从1997-10-01到今天有： " + seconds + "秒");
    }
}
