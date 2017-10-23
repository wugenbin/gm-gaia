package com.ntc.gaia.service.business.module1.impl;

import com.ntc.gaia.base.model.module1.PlotYData;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.module1.DataDynamicSimulateBusiness;
import com.ntc.gaia.service.dao.module1.DataSimulateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2017/8/16.
 */
@Service("DataDynamicSimulateBusiness")
public class DataDynamicSimulateBusinessImpl implements DataDynamicSimulateBusiness {
    @Autowired
    private DataSimulateDao dataSimulateDao;

    public List dataDynamicSimulateLogic(String userId) throws BusinessException {
        List<PlotYData> list = new ArrayList<PlotYData>(); //模拟数据
        try {
            list=dataSimulateDao.getSimulateData(userId);
            return list;
        }catch(SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    };
}
