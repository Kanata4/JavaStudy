package com.geekaca.j2.teststatic;

import java.io.OutputStream;

public class Testmain {
    public static void main(String[] args) {
        Employee employeeA = new Employee();
        employeeA.setName("Tom");
        //set开头的函数 都应该是设置值
        employeeA.setAge(23);
        employeeA.setDept("研发部");

        //静态是共享的
        Employee.companyName = "必胜客";

        Employee employeeB = new Employee();
        System.out.println("name：" + employeeB.getName());
        System.out.println("雇员B的公司：" + employeeB.companyName);

        Employee.companyName = "极客咖";

        System.out.println("公司：" + Employee.companyName);
        System.out.println("雇员A的公司：" + employeeA.companyName);
        System.out.println("=======");

        int maxAge = Employee.compareByAge(employeeA, employeeB);
        System.out.println(maxAge);
    }
}
