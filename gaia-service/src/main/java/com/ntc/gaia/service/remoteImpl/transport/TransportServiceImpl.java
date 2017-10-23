package com.ntc.gaia.service.remoteImpl.transport;

import com.ntc.gaia.base.model.transport.ArrivalPassager;
import com.ntc.gaia.base.model.transport.EnterpotDaba;
import com.ntc.gaia.base.model.transport.PassagerSort;
import com.ntc.gaia.base.model.transport.TrafficRate;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.transport.TransportService;
import com.ntc.gaia.service.business.transport.TransportBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Component("TransportService")
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportBusiness transportBusiness;

    @Override
    public List<ArrivalPassager> findArrivalPassager() throws BusinessException {
        List<ArrivalPassager> list = null;
        try{
            list = transportBusiness.findArrivalPassager();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List<EnterpotDaba> findEnterpotDaba(Integer type) throws BusinessException {
        List<EnterpotDaba> list = null;
        try{
            list = transportBusiness.findEnterpotDaba(type);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public Map<String, Object> findPassagerScene() throws BusinessException {
        Map<String, Object> map = null;
        try{
            map = transportBusiness.findPassagerScene();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  map;
    }

    @Override
    public List<PassagerSort> findPassagerSort() throws BusinessException {
        List<PassagerSort> list = null;
        try{
            list = transportBusiness.findPassagerSort();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List<TrafficRate> findTrafficRate() throws BusinessException {
        List<TrafficRate> list = null;
        try{
            list = transportBusiness.findTrafficRate();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List findTrafficPeak() throws BusinessException {
        List list = null;
        try{
            list = transportBusiness.findTrafficPeak();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }
}
