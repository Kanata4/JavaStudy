package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.EmployeeMapper;
import com.geekaca.mybatis.pojo.Employee;
import com.geekaca.mybatis.pojo.EmployeeDept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;


public class Test {

    @org.junit.Test
    public void testSelectEmpDept(){
        SqlSession sqlSession = openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDept> employeeList = employeeMapper.selectAllEmpDept();
        Assert.assertNotNull(employeeList);
        Assert.assertTrue(employeeList.size() > 0);
        employeeList.forEach(empD -> System.out.println(empD));
    }

    @org.junit.Test
    public void testInsert(){
        SqlSession sqlSession = openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = new Employee();
        emp.setEmpName("弥勒佛");
        emp.setDeptId(2);
        emp.setJoindate(LocalDate.now());
        emp.setHeight(177.0);
        emp.setSalary(40000);
        int updated = employeeMapper.insert(emp);
        Assert.assertTrue(updated > 0);
        System.out.println(emp.getId());
        Assert.assertTrue(emp.getId() != null);

    }

    @org.junit.Test
    public void testSelectAll(){
        SqlSession sqlSession = openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee>  employees = employeeMapper.selectAll();
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    @org.junit.Test
    public void testUpdateNameById(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmpName("悟空");
        SqlSession sqlSession = openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int updated = employeeMapper.updateNameById(employee);
//        System.out.println(updated);
        Assert.assertTrue(updated > 0);
    }


    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
