package com.ntc.gaia.base.model.transport;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/24.
 */
public class EnterpotDaba extends BaseEntity{

    private String taskNum;
    private String entrepotName;
    private String entrepotAddress;
    private String licenseNum;
    private Integer seatCount;
    private Integer passagerCount;
    private String targetScene;
    private Integer targetSceneId;
    private String departStatus;
    private String cityName;
    private Integer cityId;
    private String date;

  //  id,taskNum,entreportName,entrepotAddress,licenseNum,seatCount,passagerCount,targetScene,targetSceneId,departStatus,cityId,date


    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    public String getEntrepotName() {
        return entrepotName;
    }

    public void setEntrepotName(String entrepotName) {
        this.entrepotName = entrepotName;
    }

    public String getEntrepotAddress() {
        return entrepotAddress;
    }

    public void setEntrepotAddress(String entrepotAddress) {
        this.entrepotAddress = entrepotAddress;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Integer getPassagerCount() {
        return passagerCount;
    }

    public void setPassagerCount(Integer passagerCount) {
        this.passagerCount = passagerCount;
    }

    public String getTargetScene() {
        return targetScene;
    }

    public void setTargetScene(String targetScene) {
        this.targetScene = targetScene;
    }

    public Integer getTargetSceneId() {
        return targetSceneId;
    }

    public void setTargetSceneId(Integer targetSceneId) {
        this.targetSceneId = targetSceneId;
    }

    public String getDepartStatus() {
        return departStatus;
    }

    public void setDepartStatus(String departStatus) {
        this.departStatus = departStatus;
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
