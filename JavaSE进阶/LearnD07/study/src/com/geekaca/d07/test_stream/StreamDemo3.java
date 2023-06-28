package com.geekaca.d07.test_stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    //研发一部的总工资和
    static double allMoney;
    //两个部门的总工资
    static double allMoneyTotal;
    public static void main(String[] args) {

        /**
         * 两个部门的员工
         */
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(new Employee("猪八戒",'男',30000,10000,null));
        employeeList1.add(new Employee("猪3",'男',4400,1500,null));
        employeeList1.add(new Employee("猪55",'男',4400,1500,null));
        employeeList1.add(new Employee("猪11",'男',46800,2300,null));

        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(new Employee("猪",'男',330000,10000,null));
        employeeList2.add(new Employee("猪2",'女',130,1100,null));
        employeeList2.add(new Employee("猪2414",'女',7700,13400,null));
        employeeList2.add(new Employee("猪7",'女',9700,400,null));

        //1.开发一部的最高工资的员工
        //max找最大值 但是需要你传入规则 用哪个属性比较
        Employee employeeTopMoney = employeeList1.stream().max((e1,e2) ->
                Double.compare(e1.getSalary() + e1.getBonus(),e2.getSalary() + e2.getBonus()))
                .get();
        System.out.println("研发一部收入最高的是：" + employeeTopMoney);
        /**
         * 找到研发一部中收入最高的人
         * 还要利用他的信息构造一个对象 TopPerformer
         */
        TopPerformer topPerformer = employeeList1.stream().max((e1, e2) ->
                Double.compare(e1.getSalary() + e1.getBonus(), e2.getSalary()
                        + e2.getBonus()))
                .map(emp -> new TopPerformer(emp.getName(), emp.getSalary())).get();
        System.out.println("topPerformer：" + topPerformer);

        /**
         * 2.研发一部 统计平均工资
         * 先要排序
         */
        System.out.println("研发一部收入排序");
        //对工资总和 求值


        //从低到高
        employeeList1.stream().sorted((e1,e2) ->
                Double.compare(e1.getSalary() + e1.getBonus(),
                e2.getSalary() + e2.getSalary()))
                .skip(1) //跳过一个
                .limit(employeeList1.size() - 2) //保留 size-2  最后一个元素没有加入进来
                .forEach(e -> {
                    System.out.println(e);
                    allMoney += (e.getSalary() + e.getBonus());
                });
        double avgMoney1 = allMoney / (employeeList1.size() - 2);
        System.out.println("研发一部平均工资：" + avgMoney1);

        //对两个部门分别定义stream流 然后再合并
        Stream<Employee> s1 = employeeList1.stream();
        Stream<Employee> s2 = employeeList1.stream();
        //把两个部门数据放在一起统计
        Stream<Employee> s12 = Stream.concat(s1,s2);
        //1.排序 2.去掉最高最低 3.求工资的总和
        s12.sorted((e1,e2) -> Double.compare(e1.getSalary() + e1.getBonus(),e2.getSalary() + e2.getBonus()))
                .skip(1) //掐头
                .limit(employeeList1.size() + employeeList2.size() - 2) //去尾
                .forEach(e -> {
                    allMoneyTotal += (e.getSalary() + e.getSalary());
                });
        BigDecimal allMoneyDe = BigDecimal.valueOf(allMoneyTotal);
        BigDecimal employeeCnt = BigDecimal.valueOf(employeeList1.size() + employeeList2.size() - 2);
        BigDecimal avgTotal = allMoneyDe.divide(employeeCnt, 2, RoundingMode.HALF_UP);
        System.out.println("整个研发部平均工资：" + avgTotal);


    }
}
