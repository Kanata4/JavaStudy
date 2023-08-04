package com.geekaca.mybatis.pojo;

/**
 * -- 利用mybatis发送多表查询
 * SELECT * FROM dongtu_emp emp, dongtu_dept dep
 * where emp.dept_id = dep.dept_id;
 */
public class EmployeeDept extends Employee{
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "EmployeeDept{" +
                "deptName='" + deptName + '\'' +
                "empName:" + this.getEmpName() +
                '}';
    }
}
