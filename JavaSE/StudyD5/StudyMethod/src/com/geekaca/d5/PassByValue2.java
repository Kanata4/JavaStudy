package com.geekaca.d5;

import java.util.Arrays;

public class PassByValue2 {
    public static void main(String[] args) {
        int [] myArr = {10,20,30};
        change(myArr);
        System.out.println(myArr[1]);
    }
    //10 222
    public static void change(int[] arrs){
        System.out.println(Arrays.toString(arrs));
        arrs[1] = 222;
        System.out.println(Arrays.toString(arrs));
    }
}
