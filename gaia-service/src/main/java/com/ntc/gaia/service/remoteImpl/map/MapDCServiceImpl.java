package com.ntc.gaia.service.remoteImpl.map;

import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.map.MapDCService;
import com.ntc.gaia.service.business.map.MapDCBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author William
 * @date 2017/08/30
 *
 */
@Component("MapDCService")
public class MapDCServiceImpl implements MapDCService {

    public static Logger logger = Logger.getLogger(MapDCServiceImpl.class.getName());
    @Autowired
    private MapDCBusiness mapDCBusiness;


    @Override
    public List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType) {

        List<DistributionCenter> dcList = null;

        logger.info("RequestParameter:cityCode("+cityCode+")"+"centerType("+centerType+")");

        try{

            dcList = mapDCBusiness.getDCListByCityCode(cityCode,centerType);

        }catch (BusinessException e){

            LogUtil.error(this.getClass().getName(), e.getErrorMessage());

        }

        logger.info("ReturnParameter:"+dcList.toString());

        return dcList;
    }
}
