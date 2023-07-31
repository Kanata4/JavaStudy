package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Brand;

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

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     * @return
     */
    void update(Brand brand);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(int id);


    void deleteByIds(int[] ids);
}
