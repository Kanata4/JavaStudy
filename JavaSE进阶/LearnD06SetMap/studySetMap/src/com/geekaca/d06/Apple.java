package com.geekaca.d06;

/**
 * 加泛型约束
 * 说明，只允许同种类型进行比较
 */
public class Apple implements Comparable<Apple>{
    private String name;
    private String color;
    private double price;
    private int weight;
    public Apple(String name, String color, double price, int weight) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    //把当前对象和 参数o进行比较
    @Override
    public int compareTo(Apple o) {
        //根据苹果的重量进行排序
        //如果当前对象的重量 大于 对方的重量  那么是 升序
        return this.weight - o.getWeight();
    }
}
