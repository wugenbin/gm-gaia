package com.ntc.gaia.base.model.tourism;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by Administrator on 2017/9/15 0015.
 * 城市区域内景区动态
 */
public class SceneDynamic extends BaseEntity{
    private String sceneName;    //景点名称
    private Integer passagerCount;//景点当前游客数量
    private String status;        //景点当前负载状态
    private String cityName;      //景点所属城市
    private Integer cityId;       //城市id

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Integer getPassagerCount() {
        return passagerCount;
    }

    public void setPassagerCount(Integer passagerCount) {
        this.passagerCount = passagerCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
