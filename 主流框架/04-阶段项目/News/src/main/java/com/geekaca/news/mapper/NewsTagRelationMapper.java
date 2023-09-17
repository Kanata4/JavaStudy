package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsTagRelation;

/**
* @author kanata
* @description 针对表【tb_news_tag_relation】的数据库操作Mapper
* @createDate 2023-09-17 23:04:12
* @Entity com.geekaca.news.domain.NewsTagRelation
*/
public interface NewsTagRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTagRelation record);

    int insertSelective(NewsTagRelation record);

    NewsTagRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTagRelation record);

    int updateByPrimaryKey(NewsTagRelation record);

}
