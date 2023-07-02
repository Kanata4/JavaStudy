package com.geekaca.d08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestException {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5};
        //ArrayIndexOutOfBoundsException 数组越界异常
//        System.out.println(arr[9]);
        //IndexOutOfBoundsException
        List<String> list = new ArrayList<>();
//        list.get(0);
        //java.lang.NumberFormatException 无法被转换为一个浮点类型
        String str = "9.9ggg";
//        Double.parseDouble(str);

        //java.time.format.DateTimeFormatter.parseResolved0 日期解析异常
//        String strDate = "2023-09-09日 12:00:00";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse(strDate,dtf);
//        System.out.println(localDateTime);
        //NullPointerException 空指针异常
//        String myStr = null;
//        System.out.println(myStr.length());
        //类型转换异常

        //尝试执行下面大括号的代码 如果有异常 就会被catch语句捕获到
        String date = "2023年01-12 10:23:21";
        SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        try{
            Date d = sdf.parse(date);
            System.out.println("===" + d);
        }catch (ParseException ex){
            //当发生异常的时候 会自动创建对象 把异常信息放进去 ex
            //打印异常堆栈 java.text.ParseException
            ex.printStackTrace();
        }

    }
}
