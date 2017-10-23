package com.ntc.gaia.base.model.map;

import java.io.Serializable;

/**
 * @description 地图景点-客运中心连线分批展示配置实体
 * @author William
 * @date 2017/09/01
 *
 */

public class BatchesConfig implements Serializable {

    private Integer id;

    //批次明细
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
