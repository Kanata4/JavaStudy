package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    int updateById(Student student);

    //发送单个参数，注意@Param
    void deleteById(@Param("id") Integer id);

    List<Student> selectByIds(@Param("ids") int[] ids);

    List<Student> loginByUser(Student student);

    int checkLogin(Student student);
}
