package com.ntc.gaia.service.business.map.impl;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.map.MapSceneryBusiness;
import com.ntc.gaia.service.dao.map.MapSceneryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author william
 * @date 2017/08/26
 *
 */
@Service("MapSceneryBusiness")
public class MapSceneryBusinessImpl implements MapSceneryBusiness{

    @Autowired
    private MapSceneryDao mapSceneryDao;

    @Override
    public List<Scene> getSceneryListByCityCode(String cityCode) throws BusinessException {

        List<Scene> sceneryList = null;

        try {

            sceneryList = mapSceneryDao.getSceneryListByCityCode(cityCode);

        } catch (SQLException e) {

            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());

        }

        return sceneryList;

    }
}
