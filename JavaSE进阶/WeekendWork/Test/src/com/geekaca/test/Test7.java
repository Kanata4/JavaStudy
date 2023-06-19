package com.geekaca.test;

public class Test7 {
    public static void main(String[] args) {
        int[] arr1 = {3,6,1,0};
        System.out.println(findMax2(arr1));
    }

    public static int findMax2(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1){
            return 0;
        }
        int max = arr[0];
        //第一遍循环，找到最大值 还需要记住最大值的索引
        int indexOfMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max ){
                max = arr[i];
                indexOfMax = i;
            }
        }
        /**
         * 判断最大值 是否是其他元素的两倍以上
         * 不能仅仅根据当前元素判断来决定
         * 要全部通过才是符合条件
         */
        //是否全部符合条件
        boolean isPassed = true;
        for (int i = 0; i < arr.length; i++) {
            //跳过最大元素自己
            if (arr[i] != max && arr[i] * 2 > max){
                isPassed = false;
            }
        }
        if (isPassed){
            return indexOfMax;
        }else{
            return -1;
        }
    }
}
