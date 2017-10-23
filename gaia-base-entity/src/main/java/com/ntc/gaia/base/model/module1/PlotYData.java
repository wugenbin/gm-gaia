package com.ntc.gaia.base.model.module1;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * @auDthor david
 * @date 2017-7-27
 */
public class PlotYData extends BaseEntity {
    private static final long serialVersionUID = 8915030047034356258L;
    private String value0;
    private String value1;
    private String value2;

    public String getValue0() {
        return value0;
    }

    public void setValue0(String value0) {
        this.value0 = value0;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
