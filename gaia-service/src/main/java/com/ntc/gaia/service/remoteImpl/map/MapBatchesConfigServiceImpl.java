package com.ntc.gaia.service.remoteImpl.map;

import com.ntc.gaia.base.model.map.BatchesConfig;
import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.map.MapBatchesConfigService;
import com.ntc.gaia.service.business.map.MapBatchesConfigBusiness;
import com.ntc.gaia.service.business.map.MapDCBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 */
@Component("MapBatchesConfigService")
public class MapBatchesConfigServiceImpl implements MapBatchesConfigService{

    public static Logger logger = Logger.getLogger(MapBatchesConfigServiceImpl.class.getName());

    @Autowired
    private MapBatchesConfigBusiness mapBatchesConfigBusiness;

    @Override
    public List<BatchesConfig> getBatchesConfigList() {

        List<BatchesConfig> bcList = null;

        try{

            bcList = mapBatchesConfigBusiness.getBatchesConfigList();

            logger.info("ReturnParameter:"+bcList.toString());

        }catch (BusinessException e){

            LogUtil.error(this.getClass().getName(), e.getErrorMessage());

        }

        return bcList;
    }
}
