package com.ntc.gaia.web.base.vo;

import java.io.Serializable;


/**
 * 客户登录会话信息对象
 *
 * @author David
 * @date 2017-08-11
 */
public class CSessionBean implements Serializable {

    private static final long serialVersionUID = 215080776579791865L;

    // 系统Session号
    private String UID = "";

    // 客户编号
    private String cid = "";

    // 客户昵称
    private String nickname = "";

    // 客户手机
    private String msisdn = "";

    // roleName
    private String[] roleNames ;

    // roleLevel
    private Integer[] roleLevels;

    // 客户密码
    private String pwdmd5 = "";

    // 登录时间
    private String logintime = "";

    public CSessionBean() {

    }

    public CSessionBean(String UID, String cid, String nickname, String[] roleNames, String msisdn,
                        Integer[] roleLevels, String pwdmd5) {

        this.UID = UID;
        this.cid = cid;
        this.nickname = nickname;
        this.roleNames = roleNames;
        this.msisdn = msisdn;
        this.roleLevels = roleLevels;
        this.pwdmd5 = pwdmd5;

    }


    public String getCid() {
        if (cid == null) {
            cid = "";
        }
        return cid;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String uID) {
        UID = uID;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getPwdmd5() {
        return pwdmd5;
    }

    public void setPwdmd5(String pwdmd5) {
        this.pwdmd5 = pwdmd5;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String[] getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String[] roleNames) {
        this.roleNames = roleNames;
    }

    public Integer[] getRoleLevels() {
        return roleLevels;
    }

    public void setRoleLevels(Integer[] roleLevels) {
        this.roleLevels = roleLevels;
    }
}
