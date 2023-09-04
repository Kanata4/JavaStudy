package com.geekaca.ssm.service;

import com.geekaca.ssm.domain.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//添加事务
@Transactional
public interface BrandService {
    //业务层接口要见名知意 文档注释

    /**
     * 保存
     * @param brand
     * @return
     */
    public int save(Brand brand);

    /**
     * 修改
     * @param brand
     * @return
     */
    public int update(Brand brand);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Brand getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    public List<Brand> getAll(Integer pageNo, Integer pageSize);

    /**
     * 根据品牌名查询
     * @param brand
     * @return
     */
    List<Brand> getByBrandName(Brand brand);

}
