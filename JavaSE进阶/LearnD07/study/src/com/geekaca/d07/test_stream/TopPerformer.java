package com.geekaca.d07.test_stream;

public class TopPerformer {
    private String name;
    private double salary;

    public TopPerformer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TopPerformer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
