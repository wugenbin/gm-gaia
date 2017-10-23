package com.ntc.gaia.remote.transport;

import com.ntc.gaia.base.model.transport.CarInfo;
import com.ntc.gaia.base.utils.exception.BusinessException;

/**
 * @author William
 * @date 2017/10/13
 *@description 为语音查询提供服务
 */
public interface CarService {

    CarInfo getCarInfoByLicenseplate(String licenseplate);
}
