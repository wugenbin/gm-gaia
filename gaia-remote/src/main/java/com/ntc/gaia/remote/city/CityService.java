package com.ntc.gaia.remote.city;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/22.
 */
public interface CityService {

    List<City> findCityByUserId(Integer userId);
    List<City> findAllCity( );
    City findCityById(Integer id);
    City findCityByCityName(String cityName);
    Boolean addCity(City city);
    Boolean saveCity(City city);
    Boolean deleteCity(Integer id);

    List<City> findCityByProvinceId(Integer provinceId);

    List<Province> findAllProvince();

    List<TotalData> findTotalData();
}
