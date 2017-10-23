package com.ntc.gaia.service.business.transport;

import com.ntc.gaia.base.model.transport.CarInfo;
import com.ntc.gaia.base.utils.exception.BusinessException;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */
public interface CarBusiness {

    CarInfo getCarInfoByLicenseplate(String licenseplate) throws BusinessException;
}
