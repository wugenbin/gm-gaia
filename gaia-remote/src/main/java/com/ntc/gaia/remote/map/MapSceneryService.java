package com.ntc.gaia.remote.map;

import com.ntc.gaia.base.model.scene.Scene;
import java.util.List;

/**
 * @date 2017/08/26
 * @author william
 *
 */
public interface MapSceneryService {

    /**
     * @description 根据城市编码获取该城市的所有景区
     * @param cityCode
     * @return
     */
    List<Scene> getSceneryListByCityCode(String cityCode);
}
