package com.geekaca.d4.d3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

/**
 * 抢订单
 *
 * 下单截止时间 2023-6-20 14:00:00
 *
 * Tom 2023-6-20 14:00:10
 * Jerry 2023-6-20 13:59:59
 * 用程序判断谁抢单成功？
 */
public class TestBuy {
    public static void main(String[] args) {
        LocalDateTime buyDate = LocalDateTime.of(2023,6,20,14,0,00);
        LocalDateTime tomDate = LocalDateTime.of(2023,6,20,14,0,10);
        LocalDateTime jerryDate = LocalDateTime.of(2023,6,20,13,59,59);
        boolean isBuy1 = buyDate.isAfter(tomDate);
        boolean isBuy2 = buyDate.isAfter(jerryDate);

        //判断是否买到了
        System.out.println("Tom是否买到：" + isBuy1 + "。Jerry是否买到：" + isBuy2 + "。");
    }
}
