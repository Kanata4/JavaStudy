package com.geekaca.d4.d3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class TestDuration {
    public static void main(String[] args) {
        /**
         * 时间的相差
         */
        // 本地日期时间对象。
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 出生的日期时间对象
        LocalDateTime birthDate = LocalDateTime.of(2001, 10
                , 28, 01, 00, 00);
        Duration duration = Duration.between(birthDate, today);
        long days = duration.toDays();
        System.out.println("出生了多少天： " + days);
        /**
         * 如果你能活到99岁
         * 那么你还剩余多少天
         */
        LocalDateTime dateTime99 = birthDate.plusYears(99);
        System.out.println("99岁：" + dateTime99);
        Duration duration2 = Duration.between(today,dateTime99);
        long days2 = duration2.toDays();
        System.out.println("剩余： " + days2);

    }
}
