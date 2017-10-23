package com.ntc.gaia.remote.transport;

import com.ntc.gaia.base.model.transport.ArrivalPassager;
import com.ntc.gaia.base.model.transport.EnterpotDaba;
import com.ntc.gaia.base.model.transport.PassagerSort;
import com.ntc.gaia.base.model.transport.TrafficRate;
import com.ntc.gaia.base.utils.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */

public interface TransportService {
    List<ArrivalPassager> findArrivalPassager()throws BusinessException;
    List<EnterpotDaba> findEnterpotDaba(Integer type)throws BusinessException;
    Map<String,Object> findPassagerScene()throws BusinessException;
    List<PassagerSort> findPassagerSort() throws BusinessException;
    List<TrafficRate> findTrafficRate() throws BusinessException;
    List findTrafficPeak()throws BusinessException;
}
