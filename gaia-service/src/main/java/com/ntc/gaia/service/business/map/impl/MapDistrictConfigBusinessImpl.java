package com.ntc.gaia.service.business.map.impl;

import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.map.MapDistrictConfigBusiness;
import com.ntc.gaia.service.dao.map.MapDistrictConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Wulliam
 * @date 2017/08/30
 *
 */
@Service("MapDistrictConfigBusiness")
public class MapDistrictConfigBusinessImpl implements MapDistrictConfigBusiness{

    @Autowired
    private MapDistrictConfigDao mapDistrictConfigDao;

    @Override
    public List<DistrictConfig> getDistrictConfigList(String flag) throws BusinessException {

        List<DistrictConfig> districtConfigList = null;

        try {

            districtConfigList = mapDistrictConfigDao.getDistrictConfigList(flag);

        } catch (SQLException e) {

            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());

        }

        return districtConfigList;

    }
}
