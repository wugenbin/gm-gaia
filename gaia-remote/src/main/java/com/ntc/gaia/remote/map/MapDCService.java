package com.ntc.gaia.remote.map;

import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.model.scene.Scene;

import java.util.List;

/**
 * @author William
 * @date 2017/08/30
 *
 */
public interface MapDCService {

    /**
     * @description 根据城市编码获取该城市的所有集散中心
     * @param cityCode
     * @return
     */
    List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType);
}
