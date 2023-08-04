package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Employee;
import com.geekaca.mybatis.pojo.EmployeeDept;

import java.util.List;

public interface EmployeeMapper {
    //查询所有
    List<Employee> selectAll();

    int updateNameById(Employee employee);

    int insert(Employee employee);

    List<EmployeeDept> selectAllEmpDept();
}
