package com.geekaca.d5;

public class FindIndex {
    public static void main(String[] args) {
        int[] arr ={11,22,33,44,55};
        int toFind = 99;
        int index = findIndex(toFind,arr);
        if (index >= 0) {
            System.out.println(toFind + "的索引" + index);
        }else{
            System.out.println("没找到");
        }

        /**
         * 输入input: int[],int
         */
    }

    public static int findIndex(int toFind, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (toFind == arr[i]){
                return i;
            }
        }
        //约定俗成，找不到返回-1
        return -1;
    }
}
