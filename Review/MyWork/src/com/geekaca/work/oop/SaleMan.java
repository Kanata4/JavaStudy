package com.geekaca.work.oop;

public class SaleMan {
    /**
     * 定义了一个方法
     * @param money
     * @return 返回值是Car  用自己定义的类型 当作方法的返回值
     * 行为 用方法描述
     */
    public Car shouqian(double money){
        //new出来的叫对象
        Car car = new Car();
        car.color = "灰色";
        return car;
    }
}
