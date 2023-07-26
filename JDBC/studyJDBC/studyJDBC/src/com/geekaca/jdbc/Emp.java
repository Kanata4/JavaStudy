package com.geekaca.jdbc;

public class Emp {
    private String empName;
    private Integer empMoney;

    public Emp(String empName, Integer empMoney) {
        this.empName = empName;
        this.empMoney = empMoney;
    }

    public Emp() {

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpMoney() {
        return empMoney;
    }

    public void setEmpMoney(Integer empMoney) {
        this.empMoney = empMoney;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empName='" + empName + '\'' +
                ", empMoney=" + empMoney +
                '}';
    }
}
