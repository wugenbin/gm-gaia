package com.ntc.gaia.service.business.map.impl;

import com.ntc.gaia.base.model.map.BatchesConfig;
import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.map.MapBatchesConfigBusiness;
import com.ntc.gaia.service.dao.map.MapBatchesConfigDao;
import com.ntc.gaia.service.dao.map.MapDCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 *
 */
@Service("MapBatchesConfigBusiness")
public class MapBatchesConfigBusinessImpl implements MapBatchesConfigBusiness{

    @Autowired
    private MapBatchesConfigDao mapBatchesConfigDao;

    @Override
    public List<BatchesConfig> getBatchesConfigList() throws BusinessException {

        List<BatchesConfig> bcList = null;

        try {

            bcList = mapBatchesConfigDao.getBatchesConfigList();

        } catch (SQLException e) {

            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());

        }

        return bcList;

    }
}
