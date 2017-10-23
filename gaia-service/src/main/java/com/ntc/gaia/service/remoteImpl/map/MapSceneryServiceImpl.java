package com.ntc.gaia.service.remoteImpl.map;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.map.MapSceneryService;
import com.ntc.gaia.service.business.map.MapSceneryBusiness;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author William
 * @date 2017/08/26
 */
@Component("MapSceneryService")
public class MapSceneryServiceImpl implements MapSceneryService{

    public static Logger logger = Logger.getLogger(MapSceneryServiceImpl.class.getName());

    @Autowired
    private MapSceneryBusiness mapSceneryBusiness;

    @Override
    public List<Scene> getSceneryListByCityCode(String cityCode) {

        logger.info("RequestParameter:cityCode("+cityCode+")");

        List<Scene> sceneryList = null;

        try{

            sceneryList = mapSceneryBusiness.getSceneryListByCityCode(cityCode);

            logger.info("ReturnParameter:"+sceneryList.toString());

        }catch (BusinessException e){

            LogUtil.error(this.getClass().getName(), e.getErrorMessage());

        }

        return sceneryList;

    }
}
