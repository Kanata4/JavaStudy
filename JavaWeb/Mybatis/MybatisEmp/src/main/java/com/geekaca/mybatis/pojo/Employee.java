package com.geekaca.mybatis.pojo;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String empName;
    private LocalDate joindate;
    private Integer salary;
    private Double height;
    private Integer deptId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LocalDate getJoindate() {
        return joindate;
    }

    public void setJoindate(LocalDate joindate) {
        this.joindate = joindate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", height=" + height +
                ", deptId=" + deptId +
                '}';
    }
}
