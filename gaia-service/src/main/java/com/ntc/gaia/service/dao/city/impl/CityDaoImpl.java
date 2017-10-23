package com.ntc.gaia.service.dao.city.impl;

import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.base.utils.tools.WinUtil;
import com.ntc.gaia.service.dao.city.CityDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by guominchuxing on 2017/8/22.
 */
@Repository
public class CityDaoImpl extends DaoImpl implements CityDao {
    protected static Logger log = Logger.getLogger(CityDaoImpl.class);

    public List<City> findCityByUserId(Integer userId)throws SQLException {
        System.out.println("Dao------------------------------------------------ "+userId);
        List<City> list = super.queryList("findCityByUserId",userId);
       // System.out.println("Dao------------------------------------------------ "+list.size());
        return list;
    };
    public List<City> findAllCity( )throws SQLException{
        return super.queryList("findAllCity");
    };
    public City findCityById(Integer id) throws SQLException{
        return super.query("findCityById",id);
    };
    public City addCity(City city) throws SQLException{
        return super.query("addCity",city);
    };
    public Integer saveCity(City city) throws SQLException{
        return super.update("saveCity",city);
    };
    public Integer deleteCity(Integer id) throws SQLException{
        return super.delete("deleteCity",id);
    };
    public City findCityByCityName(String userName)throws SQLException {
        return super.query("findCityByCityName",userName);
    }

    public List<City> findCityByProvinceId(Integer provinceId) throws SQLException {

        return super.queryList("findCityByProvinceId",provinceId);

    };

    public  List<Province> findAllProvince() throws SQLException {
        return super.queryList("findAllProvince");
    }

    public List<TotalData> findTotalData() throws SQLException {
        log.info("------------------------------------------------Dao findTotalData");
        List<TotalData> list = new ArrayList<TotalData>();
        TotalData totalData = new TotalData();
        Random random  = new Random();
        Integer totalPassager =13600;
        Integer totalEntreport=12800;
        totalData.setTotalPassager(totalPassager + WinUtil.revise[random.nextInt(20)]);
        totalData.setTotalEntreport(totalEntreport + WinUtil.revise[random.nextInt(20)]);

        list.add(totalData);
        log.info("------------------------------------------------Dao findTotalData2"+list.size());
        return list;
    }

    ;
}