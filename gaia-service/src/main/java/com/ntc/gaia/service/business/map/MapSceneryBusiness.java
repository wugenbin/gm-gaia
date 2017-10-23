package com.ntc.gaia.service.business.map;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 *
 * @author William
 * @date 2017/08/30
 *
 */
public interface MapSceneryBusiness {

    List<Scene> getSceneryListByCityCode(String cityCode)throws BusinessException;

}
