package com.geekaca.web.mapper;

import com.geekaca.web.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int selectByUnamePass(User user);

    /**
     *
     * 单独发送的参数 需要加@Param(这里的名字才是xml中用的名字) 声明
     * 对象参数不需要加！！
     *
     * 查询是否存在用户名
     * @param uname
     * @return
     */
    int selectByUname(@Param("myUserName") String uname);

    void add(User user);

    //有更多数据
    int insertUserWithDetail(User user);

    //模糊查询，可能返回多条记录，需要用集合接收
    List<User> selectUserByName(@Param("userName") String uname);

}
