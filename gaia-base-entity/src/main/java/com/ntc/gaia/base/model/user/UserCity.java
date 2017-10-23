package com.ntc.gaia.base.model.user;

/**
 * Created by guominchuxing on 2017/9/8.
 */
public class UserCity {
    private Integer userId;
    private Integer cityId;

    public UserCity(Integer userId,Integer cityId){
        this.userId = userId;
        this.cityId = cityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
