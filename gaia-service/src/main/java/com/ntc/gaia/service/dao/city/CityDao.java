package com.ntc.gaia.service.dao.city;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/22.
 */
public interface CityDao {

    List<City> findCityByUserId(Integer userId) throws SQLException;
    List<City> findAllCity( ) throws SQLException;
    City findCityById(Integer id) throws SQLException;
    City findCityByCityName(String cityName) throws SQLException;
    City addCity(City city) throws SQLException;
    Integer saveCity(City city) throws SQLException;
    Integer deleteCity(Integer id) throws SQLException;

    List<City> findCityByProvinceId(Integer provinceId) throws SQLException;

    List<Province> findAllProvince() throws SQLException;
    List<TotalData> findTotalData() throws SQLException;
}
