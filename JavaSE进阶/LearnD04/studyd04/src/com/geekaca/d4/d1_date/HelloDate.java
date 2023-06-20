package com.geekaca.d4.d1_date;

import java.util.Date;

public class HelloDate {
    public static void main(String[] args) {


        //对应的毫秒数  时间戳  1970-01-01 00:00:00 到 代码执行的这个位置经历的毫秒数
        // 1秒 =1000毫秒
        long timeStamp = System.currentTimeMillis();
        System.out.println("timeStamp:" + timeStamp);
        // 1、创建一个Date类的对象：代表系统此刻日期时间对象, 当前时间
        // new Date() 这一时刻，时间就确定了，除非你后续通过setTime修改
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime();
        System.out.println("time: " + time);

        System.out.println("========================");
        //当前时间 往后走1小时  = 60 * 60 * 1000 毫秒
        //当前时间戳   毫秒ms   + 1小时 （60分钟   1分钟= 60秒   1second = 1000ms）
        //todo: 如果 +1小时 12秒？
        long curTime = System.currentTimeMillis();
        System.out.println("curTime: " + curTime);
        curTime += 60 * 60 * 1000;
        System.out.println("一小时后的时间戳：" + curTime);
        // 3、把时间毫秒值转换成对应的日期对象。
        Date newDate = new Date();
        newDate.setTime(curTime);
        System.out.println("一小时后：" + newDate);

    }
}
