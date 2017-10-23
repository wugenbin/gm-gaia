package com.ntc.gaia.remote.scene;

import com.ntc.gaia.base.model.scene.Scene;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/25.
 */
public interface SceneService {

    List<Scene> findScene(String cityName);
    Boolean saveScene(String cityName,Scene scene);
}
