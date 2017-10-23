package com.ntc.gaia.service.business.tourism.impl;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.service.business.tourism.TourismBusiness;
import com.ntc.gaia.service.dao.tourism.TourismDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Service("TourismBusiness")
public class TourismBusinessImpl implements TourismBusiness {
    @Autowired
    private TourismDao tourismDao;

    @Override
    public List<ArrivalHotel> findArrivalHotel() throws BusinessException {
        List<ArrivalHotel> list = null;
        try {
            list = tourismDao.findArrivalHotel();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }

    }

    @Override
    public List<ArrivalScene> findArrivalScene() throws BusinessException {
        List<ArrivalScene> list = null;
        try {
            list = tourismDao.findArrivalScene();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List<HotelRate> findHotelRate() throws BusinessException {
        List<HotelRate> list = null;
        try {
            list = tourismDao.findHotelRate();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List<VisitorRate> findVisitorRate() throws BusinessException {
        List<VisitorRate> list = null;
        try {
            list = tourismDao.findVisitorRate();
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }

    @Override
    public List<SceneDynamic> findSceneDynamic(Integer type) throws BusinessException {
        List<SceneDynamic> list = null;
        try {
            list = tourismDao.findSceneDynamic(type);
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    }
}
