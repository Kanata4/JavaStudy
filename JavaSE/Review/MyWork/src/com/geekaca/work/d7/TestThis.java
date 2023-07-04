package com.geekaca.work.d7;

public class TestThis {
    public static void main(String[] args) {
        Car car = new Car();
        //private 私有的 不允许 Car的外部直接访问
        //直接暴露 直接访问 缺少保护机制
//        car.name = "Tom";
        car.setName("劳斯莱斯");
//        car.price = -99;
        car.setPrice(99);
        car.goWith("Jerry");
    }
}

class Car {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 和谁比赛赛车
     */
    public void goWith(String name){
        //难以区分 到底在使用哪个name
        System.out.println(this.name + "正在和" + name + "比赛！");
    }
}


