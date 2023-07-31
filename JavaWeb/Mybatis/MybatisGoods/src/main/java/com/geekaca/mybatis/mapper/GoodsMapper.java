package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    //插入数据
    int insertGoods(Goods goods);

    List<Goods> selectByTitle(String title);

    List<Goods> selectByCondition(Goods goods);
}
