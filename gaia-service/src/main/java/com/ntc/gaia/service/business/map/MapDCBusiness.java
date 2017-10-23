package com.ntc.gaia.service.business.map;

import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 *
 */
public interface MapDCBusiness {

    List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType)throws BusinessException;
}
