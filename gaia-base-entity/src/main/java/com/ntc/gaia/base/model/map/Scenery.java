package com.ntc.gaia.base.model.map;

/**
 * @descripiton 景区实体
 * @author William
 * @date 2017/08/30
 */
public class Scenery extends Point{

    private String loadStatus;

    public String getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(String loadStatus) {
        this.loadStatus = loadStatus;
    }
}
