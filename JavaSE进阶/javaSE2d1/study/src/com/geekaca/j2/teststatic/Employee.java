package com.geekaca.j2.teststatic;

public class Employee {
    //引用类型的成员变量 默认值是null
    private String name;
    private int age;
    private String dept;
    //静态是共享的
    public static String companyName;

    public void showInfos(){
        System.out.println("name：" + this.name + "age：" + age + "部门：" + dept + "公司名：" + companyName);
    }

    public static int compareByAge(Employee emp1,Employee emp2){
        //static不能访问普通成员 以及this
//        System.out.println(this.name);
        //static函数不能访问非静态成员

        int age1 = emp1.getAge();
        int age2 = emp2.getAge();
        return age1>age2 ? age1:age2;
    }

    public static void show() {
        //静态可以共享 成员方法可以访问static
        System.out.println("$$$$$$$$$$$$");
    }

    public String getName() {
        show();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }
}
