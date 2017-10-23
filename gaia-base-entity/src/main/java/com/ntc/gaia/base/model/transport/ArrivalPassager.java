package com.ntc.gaia.base.model.transport;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/24.
 * 游客到港趋势
 */

public class ArrivalPassager extends BaseEntity {
    private Integer passagerCount;
    private String cityName;
    private Integer cityId;
    private String date;

    //id,passagerCount,cityId,date

    public Integer getPassagerCount() {
        return passagerCount;
    }

    public void setPassagerCount(Integer passagerCount) {
        this.passagerCount = passagerCount;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
