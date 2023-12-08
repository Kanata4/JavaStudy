package com.geekaca.stu.mapper;

import com.geekaca.stu.domain.StudentInfo;

/**
* @author kanata
* @description 针对表【student_info(学生信息表)】的数据库操作Mapper
* @createDate 2023-12-08 14:10:46
* @Entity com.geekaca.stu.domain.StudentInfo
*/
public interface StudentInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

}
