package com.ntc.gaia.service.business.map;

import com.ntc.gaia.base.model.map.BatchesConfig;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 *
 */
public interface MapBatchesConfigBusiness {

    List<BatchesConfig> getBatchesConfigList()throws BusinessException;

}
