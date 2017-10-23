package com.ntc.gaia.base.model.map;

import java.io.Serializable;

/**
 * @description 区块实体，用于配置地图上某行政区域及区域颜色
 * @author William
 * @date 2017/08/30
 *
 */
public class DistrictConfig implements Serializable {

    //id
    private Integer id = 0;
    //区块名称
    private String name;
    //区块颜色
    private String colour;
    //区块级别
    private String flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
