package com.ntc.gaia.service.business.map.impl;

import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.map.MapDCBusiness;
import com.ntc.gaia.service.dao.map.MapDCDao;
import com.ntc.gaia.service.dao.map.MapSceneryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/08/30
 */
@Service("MapDCBusiness")
public class MapDCBusinessImpl implements MapDCBusiness{

    @Autowired
    private MapDCDao mapDCDao;

    @Override
    public List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType) throws BusinessException {

        List<DistributionCenter> dcList = null;

        try {

            dcList = mapDCDao.getDCListByCityCode(cityCode,centerType);

        } catch (SQLException e) {

            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());

        }

        return dcList;

    }
}
