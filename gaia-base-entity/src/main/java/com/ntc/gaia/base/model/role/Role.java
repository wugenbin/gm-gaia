package com.ntc.gaia.base.model.role;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/23.
 */
public class Role extends BaseEntity{

    private Integer id;
    private String roleName;
    private Integer roleLevel;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleLevel() {
    return roleLevel;
}

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }
}
