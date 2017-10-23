package com.ntc.gaia.base.model.map;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * @description 地图点信息
 * @author William
 * @date 2017/08/30
 *
 */
public class Point  extends BaseEntity {

    //名称
    private String name;
    //描述
    private String desc;
    //经度
    private String lng;
    //纬度
    private String lat;
    //省份编码
    private String provinceCode;
    //城市编码
    private String cityCode;
    //地址
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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
}
