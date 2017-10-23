package com.ntc.gaia.service.business.city;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/22.
 */
public interface CityBusiness {
    List<City> findCityByUserId(Integer userId) throws BusinessException;
    List<City> findAllCity( ) throws BusinessException;
    City findCityByCityName(String cityName) throws BusinessException;
    City findCityById(Integer id) throws BusinessException;
    Boolean addCity(City city) throws BusinessException;
    Boolean saveCity(City city) throws BusinessException;
    Boolean deleteCity(Integer id) throws BusinessException;

    List<City> findCityByProvinceId(Integer provinceId) throws BusinessException;

    List<Province> findAllProvince() throws BusinessException;

    List<TotalData> findTotalData()throws BusinessException;
}
