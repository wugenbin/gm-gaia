package com.ntc.gaia.service.remoteImpl.module1;

import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.module1.DataSimulateService;
import com.ntc.gaia.service.business.module1.DataSimulateBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by david on 2017/8/16.
 */
@Component("DataSimulateService")
public class DataSimulateServiceImpl implements DataSimulateService{
    @Autowired
    private DataSimulateBusiness dataSimulateBusiness;

    List resultList=null;

    public List dataSimulateProvider(String userId){
        try {
            return dataSimulateBusiness.dataSimulateLogic(userId);
        }catch(BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return resultList;
    };
}
