package com.geekaca.test;

import org.junit.*;

public class HelloJunit {

    /**
     * 在每个@Test 方法前，后会被执行的方法
     */
//    @Before
//    public void testBefore(){
//        System.out.println("before执行--------");
//    }
//    @After
//    public void testAfter(){
//        System.out.println("after 执行------------");
//    }

    // 修饰静态方法
    @BeforeClass
    public static void beforeClass(){
        System.out.println("===beforeClass方法执行一次===");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("===afterClass方法执行一次===");
    }
    /**
     * annotation 注解 ，标识此方法 是一个 JUnit的单元测试方法
     * 可以独立运行（只适合用来测试）
     * @Test修饰的测试方法
     * 公有的  无返回值   不能有函数参数
     */
    @Test
    public void testLogin(){
        UserService userService = new UserService();
        //咱们自己明确知道，能够能够登陆成功的  是admin/123456    返回值一定true，说明登陆逻辑是没问题的
        boolean isOk = userService.isLoginOk("admin", "123456");
        System.out.println("loginOK:" + isOk);
        //绿色代表通过了单元测试， 说明函数的返回值符合预期
        /**
         * 断言
         * assertTrue 期望 参数2 值是true的
         * 参数1：  结果不符合预期的时候，会打印的描述信息
         * 参数2：  要验证的变量
         */
        //普通方法中使用它没有意义！！！
        Assert.assertTrue("登陆测试失败", isOk);
//        Assert.assertNotNull();
//        Assert.assertNull();


    }

    @Test
    public void testGetName(){
        UserService userService = new UserService();
        String uname = userService.getUsername("U009");
        System.out.println("testGetName");
        Assert.assertNotNull("getUserName失败", uname);
        //路径  覆盖到各种可能 ，这样的你的代码才称得上 健壮的 （鲁棒性 robust）
    }
}
