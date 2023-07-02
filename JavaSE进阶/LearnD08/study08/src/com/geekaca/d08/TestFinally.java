package com.geekaca.d08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFinally {
    public static void main(String[] args) {
        /**
         *
         */
        //尝试执行下面大括号的代码 如果有异常 就会被catch语句捕获到
        //就地捕获异常
        String date = "2023年01-12 10:23:21";
        SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        try{
            Date d = sdf.parse(date);
            System.out.println("===" + d);
        }catch (ParseException ex){
            //当发生异常的时候 会自动创建对象 把异常信息放进去 ex
            //打印异常堆栈 java.text.ParseException
            ex.printStackTrace();
        }finally {
            //最终
            //无论是否发生异常 此处都会执行
            //比如对资源进行释放之类
            // 你用水管（是借的）去水池取水
            //如果中途你摔倒了 比如你事先告诉别人 帮你归还水管
            System.out.println("最终执行。。。。");
        }
    }
}
