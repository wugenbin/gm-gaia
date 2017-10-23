package com.ntc.gaia.base.model.transport;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/26.
 */
public class TrafficRate extends BaseEntity {
    private float passagePublicCarRate;  //乘坐公交车游客比率
    private float passageDabaRate;   //乘坐大巴游客比率
    private float passageTaxiRate;    //乘坐出租车游客比率
    private float passageRentalCarRate;//乘坐私家车游客比率
    private float passageOtherCarRate;//乘坐其他车辆游客比率

    public float getPassagePublicCarRate() {
        return passagePublicCarRate;
    }

    public void setPassagePublicCarRate(float passagePublicCarRate) {
        this.passagePublicCarRate = passagePublicCarRate;
    }

    public float getPassageDabaRate() {
        return passageDabaRate;
    }

    public void setPassageDabaRate(float passageDabaRate) {
        this.passageDabaRate = passageDabaRate;
    }

    public float getPassageTaxiRate() {
        return passageTaxiRate;
    }

    public void setPassageTaxiRate(float passageTaxiRate) {
        this.passageTaxiRate = passageTaxiRate;
    }

    public float getPassageRentalCarRate() {
        return passageRentalCarRate;
    }

    public void setPassageRentalCarRate(float passageRentalCarRate) {
        this.passageRentalCarRate = passageRentalCarRate;
    }

    public float getPassageOtherCarRate() {
        return passageOtherCarRate;
    }

    public void setPassageOtherCarRate(float passageOtherCarRate) {
        this.passageOtherCarRate = passageOtherCarRate;
    }
}
