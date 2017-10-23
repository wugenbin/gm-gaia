package com.ntc.gaia.service.business.city.impl;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.service.business.city.CityBusiness;
import com.ntc.gaia.service.dao.city.CityDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/22.
 */
@Service("CityBusiness")
public class CityBusinessImpl implements CityBusiness {
    protected static Logger log = Logger.getLogger(CityBusinessImpl.class);
    @Autowired
    private CityDao cityDao;

    public List<City> findCityByUserId(Integer userId) throws BusinessException {
        System.out.println("Business------------------------------------------------ "+userId);
        List<City> list = null;
        try {
            list = cityDao.findCityByUserId(userId);
            System.out.println("Business------------------------------------------------ "+list.size());
            return list;
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }

    }

    ;

    public List<City> findAllCity() throws BusinessException {
        List<City> cities = null;
        try {
            cities = cityDao.findAllCity();
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return cities;
    }

    ;

    public City findCityById(Integer id) throws BusinessException {
        City city = null;
        try {
            city = cityDao.findCityById(id);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return city;
    }

    ;

    public Boolean addCity(City city) throws BusinessException {
        boolean flag = false;
        try {
            City city_t = cityDao.addCity(city);
            if (city_t!=null) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    }

    ;

    public Boolean saveCity(City city) throws BusinessException {
        boolean flag = false;
        try {
            Integer n = cityDao.saveCity(city);
            if (n > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    }

    ;

    public Boolean deleteCity(Integer id) throws BusinessException {
        boolean flag = false;
        try {
            Integer n = cityDao.deleteCity(id);
            if (n > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };

    public City findCityByCityName(String cityName) throws BusinessException {
        City city = null;
        try {
            city = cityDao.findCityByCityName(cityName);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return city;
    };

    public  List<City> findCityByProvinceId(Integer provinceId) throws BusinessException {
        List<City> lsit = null;
        try {
            lsit = cityDao.findCityByProvinceId(provinceId);
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return lsit;
    };

    public  List<Province> findAllProvince() throws BusinessException{
        List<Province> lsit = null;
        try {
            lsit = cityDao.findAllProvince();
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return lsit;
    }

    public List<TotalData> findTotalData() throws BusinessException {
        log.info("------------------------------------------------Business findTotalData");
        List<TotalData> lsit = null;
        try {
            lsit = cityDao.findTotalData();
        } catch (SQLException e) {
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        log.info("------------------------------------------------Business findTotalData2 "+lsit.size());
        return lsit;
    }

    ;

}
