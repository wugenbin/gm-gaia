package com.ntc.gaia.service.business.module1;

import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * Created by david on 2017/8/16.
 */
public interface DataDynamicSimulateBusiness {
    List dataDynamicSimulateLogic(String userId) throws BusinessException;
}
