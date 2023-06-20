package com.geekaca.d4.d3;

import java.time.LocalDateTime;

public class TestDateTime {
    public static void main(String[] args) {
        /**
         * 日期和时间
         */
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("当前：" + nowDateTime);

        System.out.println("这一年中的第几天：" + nowDateTime.getDayOfYear());
    }
}
