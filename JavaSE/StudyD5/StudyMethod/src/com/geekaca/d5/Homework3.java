package com.geekaca.d5;

public class Homework3 {
    public static void main(String[] args) {
        double[] arr1 = {10.4,-3,-6.2,1.2,-6.1,-19,-3.8,0.9,-4.5,5.5};
        isGetMoney(arr1);

    }
    public static void isGetMoney (double[] arr){
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                count1++;
            }else {
                count2++;
            }
        }
        System.out.println("赚钱的股票一共有：" + count1);
        System.out.println("赚钱的股票一共有：" + count2);
    }
}
