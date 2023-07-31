package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//mapper类
public interface BrandMapper {
    //查询所有品牌
    List<Brand> selectAll();

    /**
     * 查看详情 根据id查询
     * @param id
     * @return
     */
    Brand selectById(Integer id);

    List<Brand> selectByCondition(Map map);
}
