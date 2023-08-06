package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Question;

import java.util.List;

public interface QuestionMapper {
    List<Question> selectAll();

}
