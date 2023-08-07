package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Option;
import com.geekaca.mybatis.pojo.Question;
import com.geekaca.mybatis.pojo.Questionnaire;

import java.util.List;
import java.util.Map;

public interface QuestionnaireMapper {
    List<Questionnaire> selectAll();

    List<Option> selectQuestionnaireContentById(Map map);

}
