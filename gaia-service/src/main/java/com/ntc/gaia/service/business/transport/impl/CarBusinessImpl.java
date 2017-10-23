package com.ntc.gaia.service.business.transport.impl;

import com.ntc.gaia.base.model.transport.*;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.service.business.transport.CarBusiness;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
@Service("CarBusiness")
public class CarBusinessImpl implements CarBusiness{

    private Map<String,CarInfo> cars=new HashMap<String, CarInfo>();

    @Override
    public CarInfo getCarInfoByLicenseplate(String licenseplate) throws BusinessException {

        CarInfo car=cars.get(licenseplate);

        if(null!=car){

            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            car.setGpsTime(dateString);

        }

        return car;

    }

    public void initCars(){

        CarInfo car = new CarInfo();
        car.setLicensePlate("浙EC6505");
        car.setCarType("BUS");
        car.setCarDesc("北京新能源-EU 2017款 自动");
        //car.setGpsTime("2017/09/25 11:25:40");
        car.setCarStatus("行驶中");
        car.setCurSpeed("80");
        car.setCurDrivingKMs("60");
        car.setCurdrivingTime("09:00:25-10:30:41");
        car.setCurdrivingHours("1小时30分16秒");
        car.setAverageSpeed("40");
        car.setMaxSpeed("85");
        car.setPowerStorage("60");
        CarDriver driver=new CarDriver();
        driver.setName("王小东");
        driver.setCellPhone("13524455216");
        car.setDriver(driver);
        CarAlarm alarm=new CarAlarm();
        alarm.setFastLane(0);
        alarm.setFastBrake(0);
        alarm.setSharpTurn(0);
        alarm.setExceedSpeed(1);
        alarm.setAccident(1);
        alarm.setMalfunction(1);
        car.setBnormalAlarm(alarm);
        CarPoint point1=new CarPoint();
        point1.setLng("119.988158");
        point1.setLat("30.960423");
        CarPoint point2=new CarPoint();
        point2.setLng("119.574793");
        point2.setLat("30.596047");
        CarPath path=new CarPath();
        path.setStartPoint(point1);
        path.setEndPoint(point2);
        car.setMap(path);
        cars.put("浙EC6505",car);

        car = new CarInfo();
        car.setLicensePlate("浙EC6888");
        car.setCarType("DABA");
        car.setCarDesc("北京新能源-EU 2015款 手动");
        //car.setGpsTime("2017/09/25 11:25:40");
        car.setCarStatus("行驶中");
        car.setCurSpeed("65");
        car.setCurDrivingKMs("145");
        car.setCurdrivingTime("10:10:25-12:40:41");
        car.setCurdrivingHours("2小时20分16秒");
        car.setAverageSpeed("58");
        car.setMaxSpeed("85");
        car.setPowerStorage("60");
        driver=new CarDriver();
        driver.setName("李云龙");
        driver.setCellPhone("13524455216");
        car.setDriver(driver);
        alarm=new CarAlarm();
        alarm.setFastLane(0);
        alarm.setFastBrake(0);
        alarm.setSharpTurn(0);
        alarm.setExceedSpeed(1);
        alarm.setAccident(1);
        alarm.setMalfunction(1);
        car.setBnormalAlarm(alarm);
        point1=new CarPoint();
        point1.setLng("120.497533");
        point1.setLat("30.916315");
        point2=new CarPoint();
        point2.setLng("119.278137");
        point2.setLat("30.928707");
        path=new CarPath();
        path.setStartPoint(point1);
        path.setEndPoint(point2);
        car.setMap(path);
        cars.put("浙EC6888",car);

        car = new CarInfo();
        car.setLicensePlate("浙EC7856");
        car.setCarType("BUS");
        car.setCarDesc("北京新能源-EU 2016款 自动");
        //car.setGpsTime("2017/09/25 11:25:40");
        car.setCarStatus("行驶中");
        car.setCurSpeed("75");
        car.setCurDrivingKMs("84");
        car.setCurdrivingTime("13:20:25-14:30:41");
        car.setCurdrivingHours("1小时10分16秒");
        car.setAverageSpeed("72");
        car.setMaxSpeed("90");
        car.setPowerStorage("110");
        driver=new CarDriver();
        driver.setName("楚云飞");
        driver.setCellPhone("13524455216");
        car.setDriver(driver);
        alarm=new CarAlarm();
        alarm.setFastLane(0);
        alarm.setFastBrake(0);
        alarm.setSharpTurn(0);
        alarm.setExceedSpeed(1);
        alarm.setAccident(1);
        alarm.setMalfunction(1);
        car.setBnormalAlarm(alarm);
        point1=new CarPoint();
        point1.setLng("119.7007");
        point1.setLat("31.164337");
        point2=new CarPoint();
        point2.setLng("119.893871");
        point2.setLat("30.52639");
        path=new CarPath();
        path.setStartPoint(point1);
        path.setEndPoint(point2);
        car.setMap(path);
        cars.put("浙EC7856",car);

    }
}
