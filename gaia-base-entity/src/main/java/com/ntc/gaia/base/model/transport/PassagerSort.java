package com.ntc.gaia.base.model.transport;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/30.
 */
public class PassagerSort extends BaseEntity{
    private String carType;
    private Integer arrivalPassagerCount;
    private Integer arrivalCarCount;
    private String amPeak;
    private String midPeak;
    private String pmPeak;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getArrivalPassagerCount() {
        return arrivalPassagerCount;
    }

    public void setArrivalPassagerCount(Integer arrivalPassagerCount) {
        this.arrivalPassagerCount = arrivalPassagerCount;
    }

    public Integer getArrivalCarCount() {
        return arrivalCarCount;
    }

    public void setArrivalCarCount(Integer arrivalCarCount) {
        this.arrivalCarCount = arrivalCarCount;
    }

    public String getAmPeak() {
        return amPeak;
    }

    public void setAmPeak(String amPeak) {
        this.amPeak = amPeak;
    }

    public String getMidPeak() {
        return midPeak;
    }

    public void setMidPeak(String midPeak) {
        this.midPeak = midPeak;
    }

    public String getPmPeak() {
        return pmPeak;
    }

    public void setPmPeak(String pmPeak) {
        this.pmPeak = pmPeak;
    }
//  id,carType,arrivalPassagerCount,arrivalCarCount,amPeak,midPeak,pmPeak
}
