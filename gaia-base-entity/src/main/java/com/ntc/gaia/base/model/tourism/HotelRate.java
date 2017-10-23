package com.ntc.gaia.base.model.tourism;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by Administrator on 2017/9/15 0015.
 * 酒店入住占比
 */
public class HotelRate extends BaseEntity{
    private float oneStar;  // 1星
    private float twoStar;  // 2星
    private float threeStar;// 3星
    private float fourStar;// 4星
    private float fiveStar;// 5星

    public float getOneStar() {
        return oneStar;
    }

    public void setOneStar(float oneStar) {
        this.oneStar = oneStar;
    }

    public float getTwoStar() {
        return twoStar;
    }

    public void setTwoStar(float twoStar) {
        this.twoStar = twoStar;
    }

    public float getThreeStar() {
        return threeStar;
    }

    public void setThreeStar(float threeStar) {
        this.threeStar = threeStar;
    }

    public float getFourStar() {
        return fourStar;
    }

    public void setFourStar(float fourStar) {
        this.fourStar = fourStar;
    }

    public float getFiveStar() {
        return fiveStar;
    }

    public void setFiveStar(float fiveStar) {
        this.fiveStar = fiveStar;
    }
}
