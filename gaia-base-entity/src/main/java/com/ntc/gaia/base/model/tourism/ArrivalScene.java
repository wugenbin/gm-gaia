package com.ntc.gaia.base.model.tourism;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class ArrivalScene extends BaseEntity{

    private Integer passagerCount;
    private String cityName;
    private Integer cityId;
    private String date;

    public Integer getPassagerCount() {
        return passagerCount;
    }

    public void setPassagerCount(Integer passagerCount) {
        this.passagerCount = passagerCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
}
