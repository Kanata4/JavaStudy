package com.geekaca.d4.d3;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestInstant {
    public static void main(String[] args) {
        /**
         * JDK8时间戳获取方式
         */
        //当前的时刻对象
        Instant instant = Instant.now();
        System.out.println(instant);
        long epochSecond = instant.getEpochSecond();
        System.out.println("时间戳：" + epochSecond);
        System.out.println(System.currentTimeMillis());
        //中国所在时区 +8区
        Instant instant1 = Instant.now();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("当前时区：" + zonedDateTime);
        //知道可以转换
        //Instant -> Date

        java.util.Date date = Date.from(instant1);
        System.out.println(date);
        //Date -> Instant
        Instant instant2 = date.toInstant();
        System.out.println(instant);

    }
}
