package com.ntc.gaia.base.model.transport;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public class CarDriver implements java.io.Serializable{

    private String name;

    private String cellPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
