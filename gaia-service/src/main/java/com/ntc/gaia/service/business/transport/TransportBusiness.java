package com.ntc.gaia.service.business.transport;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.model.transport.ArrivalPassager;
import com.ntc.gaia.base.model.transport.EnterpotDaba;
import com.ntc.gaia.base.model.transport.PassagerSort;
import com.ntc.gaia.base.model.transport.TrafficRate;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public interface TransportBusiness {
    List<ArrivalPassager> findArrivalPassager()throws BusinessException;
    List<EnterpotDaba> findEnterpotDaba(Integer type)throws BusinessException;
    Map<String,Object> findPassagerScene()throws BusinessException;
    List<PassagerSort> findPassagerSort() throws BusinessException;
    List<TrafficRate> findTrafficRate() throws BusinessException;
    List findTrafficPeak() throws BusinessException;
}
