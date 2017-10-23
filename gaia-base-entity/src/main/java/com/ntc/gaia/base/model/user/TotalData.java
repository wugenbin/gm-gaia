package com.ntc.gaia.base.model.user;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by Administrator on 2017/9/20 0020.
 * 游客汇总数据：日游客接待量、集散中心日转送人次
 */
public class TotalData extends BaseEntity{

    private Integer totalPassager;
    private Integer totalEntreport;

    public Integer getTotalPassager() {
        return totalPassager;
    }

    public void setTotalPassager(Integer totalPassager) {
        this.totalPassager = totalPassager;
    }

    public Integer getTotalEntreport() {
        return totalEntreport;
    }

    public void setTotalEntreport(Integer totalEntreport) {
        this.totalEntreport = totalEntreport;
    }
}
