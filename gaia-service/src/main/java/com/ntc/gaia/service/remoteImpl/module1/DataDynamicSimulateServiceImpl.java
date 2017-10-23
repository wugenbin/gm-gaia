package com.ntc.gaia.service.remoteImpl.module1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntc.gaia.service.business.module1.DataDynamicSimulateBusiness;
import com.ntc.gaia.remote.module1.DataDynamicSimulateService;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;

/**
 * Created by david on 2017/8/16.
 */
@Component("DataDynamicSimulateService")
public class DataDynamicSimulateServiceImpl implements DataDynamicSimulateService {
    @Autowired
    private DataDynamicSimulateBusiness dataDynamicSimulateBusiness;

    List resultList=null;

    public List dataDynamicSimulateProvider(String userId){
        try {
            return dataDynamicSimulateBusiness.dataDynamicSimulateLogic(userId);
        }catch(BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return resultList;
    };
}
