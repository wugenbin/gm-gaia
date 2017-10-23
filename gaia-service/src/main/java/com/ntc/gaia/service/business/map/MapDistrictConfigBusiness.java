package com.ntc.gaia.service.business.map;

import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 *
 *@author William
 *@date 2017/08/30
 *
 */
public interface MapDistrictConfigBusiness {

    List<DistrictConfig> getDistrictConfigList(String flag)throws BusinessException;
}
