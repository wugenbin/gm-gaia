package com.ntc.gaia.service.business.scene;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/25.
 */
public interface SceneBusiness {

    List<Scene> findScene(String cityName)throws BusinessException;
    Scene findSceneBySceneName(String sceneName)throws BusinessException;
    Boolean saveScene(String cityName,Scene scene)throws BusinessException;
}
