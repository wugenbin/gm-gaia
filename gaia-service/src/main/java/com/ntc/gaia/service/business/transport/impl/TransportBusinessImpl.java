package com.ntc.gaia.service.business.transport.impl;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.model.transport.ArrivalPassager;
import com.ntc.gaia.base.model.transport.EnterpotDaba;
import com.ntc.gaia.base.model.transport.PassagerSort;
import com.ntc.gaia.base.model.transport.TrafficRate;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.transport.TransportBusiness;
import com.ntc.gaia.service.dao.transport.TransportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Service("TransportBusiness")
public class TransportBusinessImpl implements TransportBusiness {

    @Autowired
    private  TransportDao transportDao;

    @Override
    public List<ArrivalPassager> findArrivalPassager() throws BusinessException {
        List<ArrivalPassager> list = null;
        try {
            list = transportDao.findArrivalPassager();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }

    }

    @Override
    public List<EnterpotDaba> findEnterpotDaba(Integer type) throws BusinessException {
        List<EnterpotDaba> list = null;
        try {
            list = transportDao.findEnterpotDaba(type);
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public Map<String, Object> findPassagerScene() throws BusinessException {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map = transportDao.findPassagerScene();
            return map;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List<PassagerSort> findPassagerSort() throws BusinessException {
        List<PassagerSort> list = null;
        try {
            list = transportDao.findPassagerSort();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List<TrafficRate> findTrafficRate() throws BusinessException {
        List<TrafficRate> list = null;
        try {
            list = transportDao.findTrafficRate();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List findTrafficPeak() throws BusinessException {
        List list = null;
        try {
            list = transportDao.findTrafficPeak();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }
}
