package com.geekaca.web.mapper;

import com.geekaca.web.pojo.Brand;
import com.geekaca.web.pojo.Type;

import java.util.List;

public interface TypeMapper {
    List<Type> selectAllType();

    int addType(Type type);

    int deleteType(int id);


}
