package com.ntc.gaia.base.model.tourism;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by Administrator on 2017/9/15 0015.
 * 景区游客组成
 */
public class VisitorRate extends BaseEntity{
    private float seniorRate;  //老人票比率
    private float studentRate;   //学生票比率比率
    private float childrenRate;    //儿童票比率
    private float adultRate;//成人票比率

    public float getSeniorRate() {
        return seniorRate;
    }

    public void setSeniorRate(float seniorRate) {
        this.seniorRate = seniorRate;
    }

    public float getStudentRate() {
        return studentRate;
    }

    public void setStudentRate(float studentRate) {
        this.studentRate = studentRate;
    }

    public float getChildrenRate() {
        return childrenRate;
    }

    public void setChildrenRate(float childrenRate) {
        this.childrenRate = childrenRate;
    }

    public float getAdultRate() {
        return adultRate;
    }

    public void setAdultRate(float adultRate) {
        this.adultRate = adultRate;
    }
}
