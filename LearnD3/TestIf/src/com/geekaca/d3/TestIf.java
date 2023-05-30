package com.geekaca.d3;

public class TestIf {
    public static void main(String[] args) {
        /**
         *  if 分支
         */
        int heartBeat = 120;
        // if(条件表达式)
        if (heartBeat < 60 || heartBeat > 100){
            System.out.println("心跳数据是：" + heartBeat + "要进一步检查");
        } else {
            System.out.println("您心跳正常");
        }
        System.out.println("=============");
        // 写代码 要避免区间的重叠
        // 绩效
        int score = 199;
        if(score > 0 && score < 60) {
            System.out.println("绩效C");
        }else if(score >= 60 && score < 90){
            System.out.println("绩效B");
        }else if(score >= 80 && score <= 90){
            System.out.println("绩效A");
        }else if(score >= 90 && score <= 100){
            System.out.println("绩效A+");
        }
    }
}
