package com.ntc.gaia.service.dao.tourism.impl;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.base.utils.tools.WinUtil;
import com.ntc.gaia.service.dao.tourism.TourismDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Repository
public class TourismDaoImpl extends DaoImpl implements TourismDao {

    public List<ArrivalHotel> findArrivalHotel() throws SQLException{
        List<ArrivalHotel> list = new ArrayList<ArrivalHotel>();
        Random random = new Random();
        for(int i = 0;i<7;i++){
            ArrivalHotel arrivalHotel = new ArrivalHotel();
            arrivalHotel.setPassagerCount(WinUtil.passagerCount2[random.nextInt(30)]);
            list.add(arrivalHotel);
        }
        return list;
    };
    public List<ArrivalScene> findArrivalScene() throws SQLException{
        List<ArrivalScene> list = new ArrayList<ArrivalScene>();
        Random random = new Random();
        for(int i = 0;i<7;i++){
            ArrivalScene arrivalScene = new ArrivalScene();
            arrivalScene.setPassagerCount(WinUtil.passagerCount2[random.nextInt(30)]);
            list.add(arrivalScene);
        }
        return list;
    };
    public List<HotelRate> findHotelRate() throws SQLException{
        List<HotelRate> list = new ArrayList<HotelRate>();
        HotelRate hotelRate = new HotelRate();
        Random random = new Random();
        Float fiveStar =WinUtil.rate4[random.nextInt(10)];
        Float fourStar = WinUtil.rate4[random.nextInt(10)];
        Float twoStar = WinUtil.rate1[random.nextInt(10)];
        Float oneStar = WinUtil.rate2[random.nextInt(10)];
        Float threeStar = 100F - fiveStar - fourStar - twoStar - oneStar;

        hotelRate.setFiveStar(fiveStar);
        hotelRate.setFourStar(fourStar);
        hotelRate.setTwoStar(twoStar);
        hotelRate.setOneStar(oneStar);
        hotelRate.setThreeStar(threeStar);

        list.add(hotelRate);
        return list;
    };
    public List<VisitorRate> findVisitorRate() throws SQLException{
        List<VisitorRate> list = new ArrayList<VisitorRate>();
        VisitorRate visitorRate = new VisitorRate();
        Random random = new Random();
//seniorRate,studentRate, childrenRate ,adultRate
        Float adultRate =WinUtil.rate[random.nextInt(10)];
        Float studentRate = WinUtil.rate2[random.nextInt(10)];
        Float childrenRate = WinUtil.rate3[random.nextInt(10)];
        Float seniorRate =  100F - adultRate - studentRate - childrenRate;
        String result = String .format("%.2f",seniorRate);
        visitorRate.setAdultRate(adultRate);
        visitorRate.setStudentRate(studentRate);
        visitorRate.setChildrenRate(childrenRate);
        visitorRate.setSeniorRate(Float.parseFloat(result));
        list.add(visitorRate);
        return list;
    };
    public List<SceneDynamic> findSceneDynamic(Integer type) throws SQLException{
        List<SceneDynamic> list = new ArrayList<SceneDynamic>();
        Random random = new Random();

            for(int i = 0;i<15;i++){
                SceneDynamic sceneDynamic = new SceneDynamic();
                sceneDynamic.setSceneName(WinUtil.scenes[random.nextInt(14)]);
                sceneDynamic.setPassagerCount(WinUtil.passagerCount2[random.nextInt(30)]);
                sceneDynamic.setStatus(WinUtil.loadStatus[random.nextInt(4)]);
                list.add(sceneDynamic);
            }
        return list;
    };

}
