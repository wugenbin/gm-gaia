package com.ntc.gaia.service.remoteImpl.map;

import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.map.MapDistrictConfigService;
import com.ntc.gaia.service.business.map.MapDistrictConfigBusiness;
import com.ntc.gaia.service.business.map.MapSceneryBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author William
 * @date 2017/08/30
 *
 */
@Component("MapDistrictConfigService")
public class MapDistrictConfigServiceImpl implements MapDistrictConfigService{

    public static Logger logger = Logger.getLogger(MapDistrictConfigServiceImpl.class.getName());

    @Autowired
    private MapDistrictConfigBusiness mapDistrictConfigBusiness;

    @Override
    public List<DistrictConfig> getDistrictConfigList(String flag) {

        logger.info("RequestParameter:flag("+flag+")");

        List<DistrictConfig> districtConfigList = null;

        try{

            districtConfigList = mapDistrictConfigBusiness.getDistrictConfigList(flag);

            logger.info("ReturnParameter:"+districtConfigList.toString());

        }catch (BusinessException e){

            LogUtil.error(this.getClass().getName(), e.getErrorMessage());

        }

        logger.info("ReturnParameter:"+districtConfigList.toString());

        return districtConfigList;
    }
}
