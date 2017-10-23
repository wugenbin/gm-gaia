package com.ntc.gaia.base.model.transport;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public class CarInfo implements java.io.Serializable{

    private String licensePlate;
    private String carType;
    private String carDesc;
    private String gpsTime;
    private String carStatus;
    private String curSpeed;
    private String curDrivingKMs;
    private String curdrivingTime;
    private String curdrivingHours;
    private String averageSpeed;
    private String maxSpeed;
    private String powerStorage;
    private CarDriver driver;
    private CarAlarm bnormalAlarm;
    private CarPath map;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCurSpeed() {
        return curSpeed;
    }

    public void setCurSpeed(String curSpeed) {
        this.curSpeed = curSpeed;
    }

    public String getCurDrivingKMs() {
        return curDrivingKMs;
    }

    public void setCurDrivingKMs(String curDrivingKMs) {
        this.curDrivingKMs = curDrivingKMs;
    }

    public String getCurdrivingTime() {
        return curdrivingTime;
    }

    public void setCurdrivingTime(String curdrivingTime) {
        this.curdrivingTime = curdrivingTime;
    }

    public String getCurdrivingHours() {
        return curdrivingHours;
    }

    public void setCurdrivingHours(String curdrivingHours) {
        this.curdrivingHours = curdrivingHours;
    }

    public String getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(String averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getPowerStorage() {
        return powerStorage;
    }

    public void setPowerStorage(String powerStorage) {
        this.powerStorage = powerStorage;

    }

    public CarDriver getDriver() {
        return driver;
    }

    public void setDriver(CarDriver driver) {
        this.driver = driver;
    }

    public CarAlarm getBnormalAlarm() {
        return bnormalAlarm;
    }

    public void setBnormalAlarm(CarAlarm bnormalAlarm) {
        this.bnormalAlarm = bnormalAlarm;
    }

    public CarPath getMap() {
        return map;
    }

    public void setMap(CarPath map) {
        this.map = map;
    }
}
