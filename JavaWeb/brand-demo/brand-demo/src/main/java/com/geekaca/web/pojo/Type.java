package com.geekaca.web.pojo;

/**
 * -- 利用mybatis发送多表查询
 * SELECT
 *     *
 * FROM
 *     tb_brand
 *         INNER JOIN
 *     tb_type ON tb_brand.type_id = tb_type.type_id;
 */
public class Type extends Brand{
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeName='" + typeName + '\'' +
                "brandName:" + this.getBrandName() +
                '}';
    }
}
