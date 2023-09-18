package com.geekaca.news.service.impl;

import com.geekaca.news.domain.News;
import com.geekaca.news.domain.NewsTag;
import com.geekaca.news.domain.NewsTagRelation;
import com.geekaca.news.mapper.NewsMapper;
import com.geekaca.news.mapper.NewsTagMapper;
import com.geekaca.news.mapper.NewsTagRelationMapper;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsTagMapper tagMapper;

    @Autowired
    private NewsTagRelationMapper tagRelationMapper;

    public List<News> selectAll() {
        List<News> newsList = newsMapper.selectAll();
        return newsList;
    }

    public News selectById(Long id) {
        News news = newsMapper.selectById(id);
        return news;
    }

    public List<News> selectByName(News news) {
        List<News> newsList = newsMapper.selectByName(news);
        return newsList;
    }

    public List<News> findNewsList() {
        List<News> newsList = newsMapper.findNewsList();
        return newsList;
    }

    @Override
    public PageResult getPageNews(Integer pageNo, Integer pageSize) {
        int start = (pageNo - 1) * pageSize;
        List<News> newsList = newsMapper.selectByPage(start, pageSize);
        int count = newsMapper.selectNewsCount();
        PageResult pageResult = new PageResult(newsList, count, pageSize, pageNo);
        return pageResult;
    }

    @Override
    public boolean saveNews(News news) {
        /**
         * 1. 向新闻表增加一条数据
         *
         * 2. 向新闻和标签关联表 插入数据
         *      循环每一个标签，插入关联表
         *      如果是已经存在的标签，就只需要插入关联表
         *      如果是新增的标签，就还需要插入标签表，增加一个
         *
         */
        int inserted = newsMapper.insertSelective(news);
        //查询出来所有的标签的名字 id 放入HashMap 缓存便于使用 Map(tagName，tagId)
        List<NewsTag> newsTags1 = tagMapper.selectAll();
        Map<String, Integer> tagMap = new HashMap<>();
        for (int i = 0; i < newsTags1.size(); i++) {
            NewsTag newsTag = newsTags1.get(i);
            tagMap.put(newsTag.getTagName(), newsTag.getTagId());
        }
        //获取给定的所有标签
        String newsTags = news.getNewsTags();
        String[] tags = newsTags.split(",");
        for (int i = 0; i < tags.length; i++) {
            String tagName = tags[i];
            //发送sql 查询这个tag是否已经存在了
            //如果已经存在 获取对应的tagId 用来插入关联表
            Integer tagId = tagMap.get(tagName);
            if (tagId == null) {
                //如果不存在 说明是新的，插入标签表tb_news_tag,获取DB生成的tag_id，用来插入关联表
                NewsTag newsTag = new NewsTag();
                newsTag.setTagName(tagName);
                tagMapper.insertSelective(newsTag);
                //DB数据库生成的标签id
                tagId = newsTag.getTagId();

            }
            NewsTagRelation tagRelation = new NewsTagRelation();
            tagRelation.setNewsId(news.getNewsId());
            tagRelation.setTagId(tagId);
            tagRelationMapper.insertSelective(tagRelation);

            //如果在循环中发送sql语句 性能较差
        }

        return true;
    }

    @Override
    public int updateNewsViews(Long newsId) {
        int i = newsMapper.increaseViews(newsId);
        return i;
    }
}
