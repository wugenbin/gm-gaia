package com.ntc.gaia.service.dao.transport.impl;

import com.ntc.gaia.base.model.transport.*;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.base.utils.tools.RandomUtil;
import com.ntc.gaia.base.utils.tools.WinUtil;
import com.ntc.gaia.service.dao.transport.TransportDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Repository
public class TransportDaoImpl extends DaoImpl implements TransportDao {
    @Override
    public List<ArrivalPassager> findArrivalPassager() throws SQLException {
        List<ArrivalPassager> list = new ArrayList<ArrivalPassager>();
        Random random = new Random();
        for(int i = 0;i<7;i++){
            ArrivalPassager arrivalPassager = new ArrivalPassager();
            arrivalPassager.setPassagerCount(WinUtil.passagerCount[random.nextInt(20)]);

            list.add(arrivalPassager);
        }
        return list;
    }

    @Override
    public List<EnterpotDaba> findEnterpotDaba(Integer type) throws SQLException {
        List<EnterpotDaba> list = new ArrayList<EnterpotDaba>();
        Random random = new Random();

            for(int i = 0;i<15;i++){
                EnterpotDaba enterpotDaba = new EnterpotDaba();
                enterpotDaba.setLicenseNum("浙E·"+ RandomUtil.generateString(2).toUpperCase()+RandomUtil.generateNumString(3));
                enterpotDaba.setPassagerCount(WinUtil.passagerCount[random.nextInt(20)]);
                enterpotDaba.setTargetScene(WinUtil.scenes[random.nextInt(14)]);
                enterpotDaba.setDepartStatus(WinUtil.status[random.nextInt(2)]);
                list.add(enterpotDaba);
            }

        return list;
    }

    @Override
    public Map<String, Object> findPassagerScene() throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        List<PassagerScene> list1 = new ArrayList<PassagerScene>();
        List<PassagerScene> list2= new ArrayList<PassagerScene>();
        Random random = new Random();
        for(int i = 0;i<5;i++){
            PassagerScene passagerScene1 = new PassagerScene();
            PassagerScene passagerScene2 = new PassagerScene();
            passagerScene1.setSceneName(WinUtil.scenes2[i]);
            passagerScene2.setSceneName(WinUtil.scenes2[i]);

            passagerScene1.setPassagerCount(WinUtil.passagerCount[random.nextInt(20)]);
            passagerScene2.setPassagerCount(WinUtil.passagerCount[random.nextInt(20)]);

            list1.add(passagerScene1);
            list2.add(passagerScene2);

            map.put("currentWeek",list1);
            map.put("lastWeek",list2);
        }
        return map;
    }

    @Override
    public List<PassagerSort> findPassagerSort() throws SQLException {
        List<PassagerSort> list = new ArrayList<PassagerSort>();
        Random random = new Random();
        for(int i = 0;i<3;i++){
            PassagerSort passagerSort = new PassagerSort();
            passagerSort.setCarType(WinUtil.carType[i]);
            passagerSort.setArrivalCarCount(WinUtil.CarCount[random.nextInt(20)]);
            passagerSort.setArrivalPassagerCount(WinUtil.passagerCount[random.nextInt(20)]);
            list.add(passagerSort);
        }
        return list;
    }

    @Override
    public List<TrafficRate> findTrafficRate() throws SQLException {
      // passagePublicCarRate,passageDabaRate,passageTaxiRate,passageRentalCarRate,passageOtherCarRate;
        List<TrafficRate> list = new ArrayList<TrafficRate>();
        TrafficRate trafficRate = new TrafficRate();
        Random random = new Random();

        Float passageDabaRate = WinUtil.rate1[random.nextInt(10)];
        Float passageTaxiRate = WinUtil.rate2[random.nextInt(10)];
        Float passagePublicCarRate =WinUtil.rate3[random.nextInt(10)];
        Float passageRentalCarRate =100F - passageDabaRate - passageTaxiRate - passagePublicCarRate;

        String result = String .format("%.2f",passageRentalCarRate);

        trafficRate.setPassageDabaRate(passageDabaRate);
        trafficRate.setPassageTaxiRate(passageTaxiRate);
        trafficRate.setPassagePublicCarRate(passagePublicCarRate);
        trafficRate.setPassageRentalCarRate(Float.parseFloat(result));
        list.add(trafficRate);
        return list;
    }

    @Override
    public List findTrafficPeak() throws SQLException {
        List list = new ArrayList();
        List list1 = new ArrayList();
        List list2= new ArrayList();
        List list3= new ArrayList();
        Random random = new Random();
        for(int i=0;i<31;i++){
            list1.add(WinUtil.passagerCount3[random.nextInt(50)]);
            list2.add(WinUtil.passagerCount3[random.nextInt(50)]);
            list3.add(WinUtil.passagerCount3[random.nextInt(50)]);
        }
        list.add(list1);
        list.add(list2);
        list.add(list3);
        return list;
    }
}
