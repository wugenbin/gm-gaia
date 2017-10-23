package com.ntc.gaia.service.remoteImpl.city;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.city.CityService;
import com.ntc.gaia.service.business.city.CityBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/22.
 */
@Component("CityService")
public class CityServiceImpl implements CityService {
    protected static Logger log = Logger.getLogger(CityServiceImpl.class);
    @Autowired
   private CityBusiness cityBusiness;

   public List<City> findCityByUserId(Integer userId){

      // System.out.println("Service------------------------------------------------"+userName);
        List<City>  cities = null;
        try{
            cities = cityBusiness.findCityByUserId(userId);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  cities;

    };
    public List<City> findAllCity( ){
        List<City>  cities = null;
        try{
            cities = cityBusiness.findAllCity();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  cities;
    };
    public City findCityById(Integer id){
        City  city = null;
        try{
            city =  cityBusiness.findCityById(id);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return city;
    };
    public Boolean addCity(City city){
        boolean  flag = false;
        try{
            flag =  cityBusiness.addCity(city);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return flag;
    };
    public Boolean saveCity(City city){
        boolean  flag = false;
        try{
            flag =  cityBusiness.saveCity(city);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return flag;
    };
    public Boolean deleteCity(Integer id){
        boolean  flag = false;
        try{
            flag =  cityBusiness.deleteCity(id);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return flag;
    };

    public City findCityByCityName(String cityName){
        City  city = null;
        try{
            city =  cityBusiness.findCityByCityName(cityName);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return city;
    };

    public List<City> findCityByProvinceId(Integer provinceId){
        List<City>  list = null;
        try{
            list =  cityBusiness.findCityByProvinceId(provinceId);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return list;
    };

    public List<Province> findAllProvince(){
        List<Province>  list = null;
        try{
            list =  cityBusiness.findAllProvince();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return list;
    }

    public List<TotalData> findTotalData() {
        log.info("------------------------------------------------service findTotalData");
        List<TotalData>  list = null;
        try{
            list =  cityBusiness.findTotalData();
            log.info("------------------------------------------------service findTotalData " + list.get(0).getTotalEntreport());
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }

        return list;
    }

    ;

}
