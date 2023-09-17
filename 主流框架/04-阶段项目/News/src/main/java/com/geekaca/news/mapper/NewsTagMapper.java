package com.geekaca.news.mapper;

import com.geekaca.news.domain.NewsTag;

import java.util.List;

/**
* @author kanata
* @description 针对表【tb_news_tag】的数据库操作Mapper
* @createDate 2023-09-17 23:04:12
* @Entity com.geekaca.news.domain.NewsTag
*/
public interface NewsTagMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsTag record);

    int insertSelective(NewsTag record);

    NewsTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsTag record);

    int updateByPrimaryKey(NewsTag record);

    List<NewsTag> selectAll();

}
