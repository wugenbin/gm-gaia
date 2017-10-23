package com.ntc.gaia.base.model.user;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/21.
 */
public class User extends BaseEntity {

    private String userName;
    private String password;
    private Integer cityId;
    private Integer provinceId;
    private Integer roleType;  //用户角色类型  1：运管局  2：旅委  3：集散中心 4：客运中心 5：轨道中心 6：景点管理员 7：游客 10：系统管理员
    private String roleName;   //角色名称
    private String registTime;

    public User(){

    }

    public User(Integer id,String userName,String password,Integer cityId,Integer provinceId){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cityId = cityId;
        this.provinceId = provinceId;


    }

    public User(String userName,String password,Integer cityId,Integer provinceId,Integer roleType,String roleName){
        this.userName = userName;
        this.password = password;
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.roleType = roleType;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
