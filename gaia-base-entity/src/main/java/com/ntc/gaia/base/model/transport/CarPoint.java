package com.ntc.gaia.base.model.transport;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public class CarPoint implements java.io.Serializable{

    private String lng;
    private String lat;

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
}
