package com.ntc.gaia.remote.map;

import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.model.scene.Scene;

import java.util.List;

/**
 *
 * @author William
 * @date 2017/08/30
 *
 */
public interface MapDistrictConfigService {

    /**
     * @description 获取区域配置信息
     * @param flag
     * @return
     */
    List<DistrictConfig> getDistrictConfigList(String flag);

}
