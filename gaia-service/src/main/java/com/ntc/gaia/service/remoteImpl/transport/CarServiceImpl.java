package com.ntc.gaia.service.remoteImpl.transport;

import com.ntc.gaia.base.model.transport.CarInfo;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.transport.CarService;
import com.ntc.gaia.service.business.transport.CarBusiness;
import com.ntc.gaia.service.business.transport.TransportBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
@Component("CarService")
public class CarServiceImpl implements CarService{

    public static Logger logger = Logger.getLogger(CarServiceImpl.class.getName());

    @Autowired
    private CarBusiness carBusiness;

    @Override
    public CarInfo getCarInfoByLicenseplate(String licenseplate){

        CarInfo carInfo=null;

        try{

            carInfo=carBusiness.getCarInfoByLicenseplate(licenseplate);

        }catch (BusinessException e){

            LogUtil.error(this.getClass().getName(), e.getErrorMessage());

            e.printStackTrace();

            logger.info(e.getStackTrace());

        }

        return carInfo;
    }
}
