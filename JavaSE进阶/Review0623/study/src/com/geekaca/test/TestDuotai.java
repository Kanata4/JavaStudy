package com.geekaca.test;

public class TestDuotai {
    public static void main(String[] args) {
        /**
         * 多态
         * OOP 三大特征之一
         * 封装 继承
         *
         * 多态 体现
         *
         * 好处 路更宽
         * 父类类型 变量 = 子类对象
         */
        UserService userService = new UserService();
        userLogin(userService);
    }

    /**
     * 可以传入进来 任何 UserService的子类
     * 函数 参数 声明成父类类型
     * 具有很强的可扩展性
     * 有一天想要换一个实现 只需要做一个子类继承 然后把子类对象传进进来就行了
     *
     * 传入参数 支持任意的子类对象
     * 更换传入的对象 对函数内部不影响
     * @param userService
     */
    public static void userLogin(UserService userService){
        //模拟用户登录过程，显示系统的首页
        /**
         * 1.从网页用户输入了用户名 密码登录
         * 2.查询系统 商品列表 显示首页
         */
        boolean isLoginOk = userService.checkLogin("tom", "123");
        if (isLoginOk){
            System.out.println("进入首页");
        } else {
            System.out.println("网页上显示登陆失败");
        }
    }
}
