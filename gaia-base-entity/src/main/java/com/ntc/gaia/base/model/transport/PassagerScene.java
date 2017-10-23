package com.ntc.gaia.base.model.transport;

import com.ntc.gaia.base.model.base.BaseEntity;

/**
 * Created by guominchuxing on 2017/8/24.
 */
public class PassagerScene extends BaseEntity{
    private String sceneName;
    private Integer sceneId;
    private Integer passagerCount;
    private String date;

   // sceneName,sceneId,passagerCount,date

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getPassagerCount() {
        return passagerCount;
    }

    public void setPassagerCount(Integer passagerCount) {
        this.passagerCount = passagerCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
