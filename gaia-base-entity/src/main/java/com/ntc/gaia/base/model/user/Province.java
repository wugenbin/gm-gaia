package com.ntc.gaia.base.model.user;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/9/7.
 */
public class Province extends BaseEntity{
  //  id,provinceName,provinceCode,provinceLevel
    private String provinceName;
    private String provinceCode;
    private String provinceLevel;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceLevel() {
        return provinceLevel;
    }

    public void setProvinceLevel(String provinceLevel) {
        this.provinceLevel = provinceLevel;
    }
}
