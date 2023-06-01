package com.geekaca.d5;

public class PrintArr {
    public static void main(String[] args) {
        System.out.println();
        int[] arr1 = {12,34,56,78,99};
        arrayResult(arr1);
    }

    public static void arrayResult(int[] arr) {
        String str = "数组的内容为：[";
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1){
                str = str + arr[i];
            }else {
                str = str + arr[i] + ",";
            }
        }
        str += "]";
        System.out.print(str);
    }
}
