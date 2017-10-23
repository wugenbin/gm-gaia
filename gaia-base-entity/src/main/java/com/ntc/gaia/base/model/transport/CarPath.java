package com.ntc.gaia.base.model.transport;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public class CarPath implements java.io.Serializable{

    private CarPoint startPoint;

    private CarPoint endPoint;

    public CarPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(CarPoint startPoint) {
        this.startPoint = startPoint;
    }

    public CarPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(CarPoint endPoint) {
        this.endPoint = endPoint;
    }
}
