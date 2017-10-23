package com.ntc.gaia.service.dao.scene;

import com.ntc.gaia.base.model.scene.Scene;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/25.
 */

public interface  SceneDao {

    List<Scene> findScene(String cityName)throws SQLException;
    Boolean saveScene(String cityName,Scene scene)throws SQLException;
    Scene findSceneBySceneName(String sceneName) throws SQLException;

}
