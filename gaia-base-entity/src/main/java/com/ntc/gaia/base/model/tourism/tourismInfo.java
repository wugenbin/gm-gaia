package com.ntc.gaia.base.model.tourism;

/**
 * Created by Administrator on 2017/9/16 0016.
 * 接收参数的对象
 */
public class TourismInfo {

    private Integer id;
    private String content;
    private Integer roleType;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getType() {
        return type;

    }

    public void setType(Integer type) {
        this.type = type;
    }
}
