package com.geekaca.test;

/**
   模拟  业务方法
 */
public class UserService {
    /**
     * 模拟登录操作
     *  张
     *
     *  wu
     * @param loginName 用户名
     * @param passWord 密码
     * @return
     */
    public boolean isLoginOk(String loginName , String passWord){
        //连接数据库 验证登陆是否成功
        if("admin".equals(loginName) && "123456".equals(passWord)){
            //某天不小心把函数改乱了
            return true;
        }else {
            return false;
        }
    }

    public void selectNames(){
        System.out.println(10/2);
        System.out.println("查询全部用户名称成功~~");
    }
    public String getUsername(String userId){
        return null;
    }
}
