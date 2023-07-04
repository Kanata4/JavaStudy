package com.geekaca.studentsys;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public enum StudentManager {
    INSTANCE;
    /**
     * key: 学号
     * value: 学生对象
     */
    private static final Map<String, Student> STU_MAPS = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentManager.class);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /*
        1:用输出语句完成主界面的编写
        2:用Scanner实现键盘录入数据
        3:用switch语句完成操作的选择
        4:用循环完成再次回到主界面
    */
    public static void main(String[] args) {
        //创建集合对象，用于保存学生数据信息
//		ArrayList<Student> array = new ArrayList<Student>();
        StudentManager studentManager = StudentManager.INSTANCE;
        studentManager.mainMenu();


    }

    public void mainMenu() {
        //用循环完成再次回到主界面
        while (true) {
            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 搜索学生");
            System.out.println("6 退出");
            System.out.println("请输入你的选择：");

            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //用switch语句完成操作的选择
            switch (line) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudent();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    //todo: 实现输入搜索
                    findStuByName();
                    break;
                case "6":
                    System.out.println("谢谢使用");
                    System.exit(0); //JVM退出
            }
        }
    }

    /**
     * 模糊搜索学生
     * 根据名字
     */
    private void findStuByName() {
        System.out.println("请输入要搜索的学生名字(或者名字中的字):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        /**
         * 到学生集合中去搜索
         * 看看哪几个学生名字中包含 输入的字
         * 对map进行遍历
         */
        final boolean[] isFind = {false};//是否找到
        STU_MAPS.forEach((key, stu)->{
            //key : sid 学号     stu： Student对象
            //取出每一个学生的名字，判断
            String name = stu.getName();
            //判断name字符串中是否含有 输入的字  input
            //如何判断一个字符串中是否含有另一个字符串
            if(name.contains(input)){
                //找到了一个
                System.out.println("找到一个学生，名字含有: "+ input + " 信息："+ stu.getInfo() );
                isFind[0] = true;
            }
        });
        if (!isFind[0]){
            System.out.println("没有找到名字含有 "+ input +" 的学生");
        }
    }

    //定义一个方法，用于添加学生信息
    public void addStudent() {
        //键盘录入学生对象所需要的数据,显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);

        String sid;
        //你输入学号，如果学号已经被占用，就会继续while true
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();

            boolean flag = isUsed(sid);
            if (flag) {
                System.out.println("你输入的学号已经被占用，请重新输入");
//				//结束本次循环，继续下次循环
//				continue;
            } else {
                //终止循环，说明学号不重复，不会拦截你了
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();

        System.out.println("请输入学生出生日期(格式形如：2002-09-09)：");
        String birth = sc.nextLine();

        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();

        //把学生信息创建对象 存入map
        Student stu = new Student();
        stu.setName(name);
        stu.setSid(sid);
        stu.setAddress(address);
        //String -> LocalDate
        //home  end按键 快速到行首，行尾
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("日期格式不对");
            e.printStackTrace();
            return;
        }

        stu.setBirth(birthDate);
        STU_MAPS.put(sid, stu);
        LOGGER.info("添加学生: "+ stu.getInfo());
        //给出添加成功提示
        System.out.println("添加学生成功");
    }

    //定义一个方法，判断学号是否被使用
    public boolean isUsed(String sid) {
        //如果与集合中的某一个学生学号相同，返回true;如果都不相同，返回false
        return STU_MAPS.containsKey(sid);
    }


    //定义一个方法，用于查看学生信息
    public void findAllStudent() {
        //判断集合中是否有数据，如果没有显示提示信息
        if (STU_MAPS.isEmpty()) {
            System.out.println("无信息，请先添加信息再查询");
            //为了让程序不再往下执行，我们在这里写上return;
            return;
        }

        //显示表头信息
        //\t其实是一个tab键的位置
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");

        STU_MAPS.forEach((key, value) -> {
            System.out.println(key + "\t" + value.getName() + "\t" + value.getBirth().format(dateTimeFormatter) + "岁\t\t" + value.getAddress());
        });

    }

    //定义一个方法，用于删除学生信息   业务描述-> 具体代码逻辑
    public void deleteStudent() {
        LOGGER.info(" 执行删除 ");
        //键盘录入要删除的学生学号,显示提示信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号：");
        String sid = sc.nextLine();

        if (STU_MAPS.containsKey(sid)) {
            //如果map中存在这个学号
            //执行 删除
            Student removedStu = STU_MAPS.remove(sid);
            System.out.println("学号: " + sid + "删除成功! 信息如下：");
            System.out.println(removedStu);
            LOGGER.info("执行删除 "+ removedStu.getInfo());
        } else {
            //不存在
            System.out.println("这个学号不存在：" + sid);
        }

        //在删除/修改学生操作前，对学号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作

    }

    //定义一个方法，用于修改学生信息
    public void updateStudent() {
        LOGGER.info("执行更新");
        //键盘录入要修改的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的学生的学号：");
        String sid = sc.nextLine();

        //键盘录入要修改的学生信息
        System.out.println("请输入学生新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生新出生日期(格式：2002-09-09)：");
        String birth = sc.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = sc.nextLine();
        /**
         * 修改
         * 如何依赖 key，来修改 map中的key value值
         * 先用key找到学生对象
         * 然后修改学生对象的属性值
         */
        if (!STU_MAPS.containsKey(sid)) {
            //如果没有这个key
            System.out.println("没有找到这个学号：" + sid);
            //直接退出函数
            return;
        }
        Student student = STU_MAPS.get(sid);
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            System.out.println("日期格式不对");
            e.printStackTrace();
            return;
        }
        student.setBirth(birthDate);
        student.setAddress(address);
        student.setName(name);
        //是否需要再次put回去？ xuyao 1  no2
        //不需要，即使你做了也不影响
//        STU_MAPS.put(sid, student);
        //给出修改成功提示
        System.out.println("修改学生成功");
    }

    /**
     * 查找出生日期大于指定值的学生
     *
     * @param
     * @return
     */
    public List<Student> findStuByBirth(String dateStr) {
        List<Student> studentList = new ArrayList<>();
        LocalDate date = LocalDate.parse(dateStr, dateTimeFormatter);
        STU_MAPS.forEach((stuId, student) -> {
            LocalDate birth = student.getBirth();
            /**
             * 如果当前学生 生日是在指定日期之前
             */
            if (birth.isBefore(date)) {
                studentList.add(student);
            }
        });
        return studentList;
    }
}