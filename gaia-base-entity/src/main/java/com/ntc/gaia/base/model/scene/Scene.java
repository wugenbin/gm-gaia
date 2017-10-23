package com.ntc.gaia.base.model.scene;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/24.
 */
public class Scene extends BaseEntity{

    private String sceneName;
    private String scenedesc;
    private float lng;
    private float lat;
    private Integer iconid;
    private String provinceCode;
    private String cityCode;
    private String address;
    private String loadStatus;
    private String threshold;
    private String sceneLevel;

    // id,sceneName,scenedesc,lng,lat,iconid,provinceCode,cityCode,address,loadStatus,threshold,sceneLevel


    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getScenedesc() {
        return scenedesc;
    }

    public void setScenedesc(String scenedesc) {
        this.scenedesc = scenedesc;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public Integer getIconid() {
        return iconid;
    }

    public void setIconid(Integer iconid) {
        this.iconid = iconid;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(String loadStatus) {
        this.loadStatus = loadStatus;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getSceneLevel() {
        return sceneLevel;
    }

    public void setSceneLevel(String sceneLevel) {
        this.sceneLevel = sceneLevel;
    }
}
