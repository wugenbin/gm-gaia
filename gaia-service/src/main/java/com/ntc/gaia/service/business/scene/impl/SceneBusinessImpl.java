package com.ntc.gaia.service.business.scene.impl;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.scene.SceneBusiness;
import com.ntc.gaia.service.dao.scene.SceneDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guominchuxing on 2017/8/25.
 */
public class SceneBusinessImpl implements SceneBusiness {
    @Autowired
    private SceneDao sceneDao;

    @Override
    public List<Scene> findScene(String cityName) throws BusinessException {
        List<Scene> scenes = null;
        try {
            scenes = sceneDao.findScene(cityName);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return scenes;
    }

    @Override
    public Boolean saveScene(String cityName, Scene scene) throws BusinessException {
        boolean flag = false;

        try {
            flag = sceneDao.saveScene(cityName,scene);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    }
    @Override
    public Scene findSceneBySceneName(String sceneName)throws BusinessException {
        Scene scene = null;
        try {
            scene = sceneDao.findSceneBySceneName(sceneName);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return scene;
    }
}
