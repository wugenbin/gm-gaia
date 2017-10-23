package com.ntc.gaia.remote.map;

import com.ntc.gaia.base.model.map.BatchesConfig;

import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 */
public interface MapBatchesConfigService {

    /**
     * @description 获取地图连线批次配置信息
     * @return
     */
    List<BatchesConfig> getBatchesConfigList();
}
