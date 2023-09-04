package com.geekaca.ssm.controller;

import com.geekaca.ssm.domain.Brand;
import com.geekaca.ssm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//注解 控制器类
@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/save")
    public Result save(@RequestBody Brand brand) {
        int save = brandService.save(brand);
        Integer code = (save > 0 ? Code.SAVE_OK : Code.SAVE_ERR);
        String msg = save > 0 ? "" : "保存失败";
        Result result = new Result(code,msg,save);
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Brand brand) {
        int update = brandService.update(brand);
        Integer code = (update > 0 ? Code.UPDATE_OK : Code.UPDATE_ERR);
        String msg = update > 0 ? "" : "更新失败";
        Result result = new Result(code,msg,update);
        return result;
    }

    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        int delete = brandService.delete(id);
        Integer code = (delete > 0 ? Code.DELETE_OK : Code.DELETE_ERR);
        String msg = delete > 0 ? "" : "删除失败";
        Result result = new Result(code,msg,delete);
        return result;
    }

    @RequestMapping("/get/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        Brand brand = brandService.getById(id);
        Integer code = (brand ==  null  ? Code. GET_ERR: Code.GET_OK);
        String msg = (brand ==  null  ? "" : "查询失败");
        Result result = new Result(code,msg,brand);
        return result;
    }

    @RequestMapping("/all")
    public Result getAll(Integer pageNo, Integer cntPerPage) {
        if (pageNo == null){
            pageNo = 1;
        }
        if (cntPerPage == null){
            cntPerPage = 10;
        }
        List<Brand> brands = brandService.getAll(pageNo,cntPerPage);
        Integer code = (brands ==  null  ? Code. GET_ERR: Code.GET_OK);
        String msg = (brands ==  null  ? "" : "查询失败");
        Result result = new Result(code,msg,brands);
        return result;
    }

    @RequestMapping("/getByName")
    public Result getByBrandName(@RequestBody Brand brand) {
        List<Brand> brands = brandService.getByBrandName(brand);
        Integer code = (brands ==  null  ? Code. GET_ERR: Code.GET_OK);
        String msg = (brands ==  null  ? "" : "查询失败");
        Result result = new Result(code,msg,brands);
        return result;
    }
}
