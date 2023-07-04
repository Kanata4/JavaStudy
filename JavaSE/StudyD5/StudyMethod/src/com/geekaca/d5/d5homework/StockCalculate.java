package com.geekaca.d5.d5homework;

public class StockCalculate {
    //sublime
    public static void main(String[] args) {
        double[] myStocks = {10.4,-3,-6.2,1.2,-6.1,-19,-3.8,0.9,-4.5,5.5};
        showStock(myStocks);
    }
    /**
     * 输入input
     * 返回值(output)
     */
    public static void showStock(double[] stocks) {
        int zhuan =0;
        int pei = 0;
        int noChange = 0;

        for (int i = 0; i < stocks.length; i++) {
            if (stocks[i] > 0){
                zhuan++;
            }else if(stocks[i] < 0){
                pei++;
            }else{
                noChange++;
            }
        }
        System.out.println("赚钱的股票数量：" + zhuan);
        System.out.println("赔钱的股票数量：" + pei);
        System.out.println("没变化的股票数量：" + noChange);
    }

}
