package com.geekaca.d3;

public class TestSwitch2 {
    public static void main(String[] args) {
        /**
         * switch的穿透
         */
        String weekDay = "周五";
        switch (weekDay){
            case "周一":
                System.out.println("埋头苦干：解决bug");
//                break;
            case "周二":
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周三":
                System.out.println("是");
                break;
            case "周四":
                System.out.println("s");
                break;
            case "周五":
                System.out.println("aa");
                break;
            case "周六":
                System.out.println("相亲");
                break;
            case "周日":
                System.out.println("郁郁寡欢");
                break;
            default:
                System.out.println("日期有误");
                break;
        }
//        long distance = 5000L;
//        switch (distance){
//
//        }
        String friDay = "周五";
        switch (weekDay){
            //case 后面跟的要求常量表达式（字面量） 不能放变量
//            case friDay:
        }

        int month = 2;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " 月有31天");
                break;
            case 2:
                System.out.println(month + " 月有28天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " 月有30天");
                break;
            default:
                System.out.println("月份有误");
                break;
        }
    }
}
