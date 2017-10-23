package com.ntc.gaia.base.model.transport;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public class CarAlarm implements java.io.Serializable{

    private Integer fastLane;
    private Integer fastBrake;
    private Integer sharpTurn;
    private Integer exceedSpeed;
    private Integer malfunction;
    private Integer accident;

    public Integer getFastLane() {
        return fastLane;
    }

    public void setFastLane(Integer fastLane) {
        this.fastLane = fastLane;
    }

    public Integer getFastBrake() {
        return fastBrake;
    }

    public void setFastBrake(Integer fastBrake) {
        this.fastBrake = fastBrake;
    }

    public Integer getSharpTurn() {
        return sharpTurn;
    }

    public void setSharpTurn(Integer sharpTurn) {
        this.sharpTurn = sharpTurn;
    }

    public Integer getExceedSpeed() {
        return exceedSpeed;
    }

    public void setExceedSpeed(Integer exceedSpeed) {
        this.exceedSpeed = exceedSpeed;
    }

    public Integer getMalfunction() {
        return malfunction;
    }

    public void setMalfunction(Integer malfunction) {
        this.malfunction = malfunction;
    }

    public Integer getAccident() {
        return accident;
    }

    public void setAccident(Integer accident) {
        this.accident = accident;
    }
}
