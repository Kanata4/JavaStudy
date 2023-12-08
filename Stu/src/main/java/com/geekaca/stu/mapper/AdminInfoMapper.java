package com.geekaca.stu.mapper;

import com.geekaca.stu.domain.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author kanata
* @description 针对表【admin_info(管理员信息表)】的数据库操作Mapper
* @createDate 2023-12-08 14:52:03
* @Entity com.geekaca.stu.domain.AdminInfo
*/
@Mapper
public interface AdminInfoMapper {


    int deleteByPrimaryKey(Long id);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);

    //多个参数要用@Param注解
    AdminInfo findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
