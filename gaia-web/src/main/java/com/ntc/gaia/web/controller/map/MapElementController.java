package com.ntc.gaia.web.controller.map;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.map.BatchesConfig;
import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.base.utils.tools.ListUtils;
import com.ntc.gaia.remote.map.MapBatchesConfigService;
import com.ntc.gaia.remote.map.MapDCService;
import com.ntc.gaia.remote.map.MapDistrictConfigService;
import com.ntc.gaia.remote.map.MapSceneryService;
import com.ntc.gaia.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2017/8/26
 * @author William
 */
@Controller
@RequestMapping(value = "/MapElement")
public class MapElementController extends BaseController {

    @Autowired
    private RpcProxy rpcProxy;

    private MapSceneryService mapSceneryService;

    private MapDCService mapDCService;

    private MapDistrictConfigService mapDistrictConfigService;

    private MapBatchesConfigService mapBatchesConfigService;

    /**
     * 根据城市编码获取该城市的所有景点信息
     * @param cityCode
     */
    @RequestMapping(value = "/getSceneryList")
    public void getSceneryAreaList(String cityCode){

        List<Scene> sceneryList=null;

        ResultVo resultVo = new ResultVo();

        try{

            mapSceneryService=rpcProxy.create(MapSceneryService.class) ;

            sceneryList = mapSceneryService.getSceneryListByCityCode(cityCode);

            if(!ListUtils.empty(sceneryList)){

                resultVo.success(sceneryList);

            }else{

                resultVo.addError("未查找出景区");

            }
            write(resultVo);

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    /**
     * 根据城市编码获取该城市的所有集散中心信息
     * @param cityCode
     */
    @RequestMapping(value = "/getDCList")
    public void getDCList(String cityCode,String centerType){

        List<DistributionCenter> dcList=null;

        ResultVo resultVo = new ResultVo();

        try{

            mapDCService=rpcProxy.create(MapDCService.class) ;

            dcList = mapDCService.getDCListByCityCode(cityCode,centerType);

            if(!ListUtils.empty(dcList)){

                resultVo.success(dcList);

            }else{

                resultVo.addError("未查找出集散中心");

            }
            write(resultVo);

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    /**
     * @description 获取区域配置信息
     * @param flag
     */
    @RequestMapping(value = "/getDistrictConfigList")
    public void getDistrictConfigList(String flag){

        List<DistrictConfig> districtConfigList=null;

        ResultVo resultVo = new ResultVo();

        try{

            mapDistrictConfigService=rpcProxy.create(MapDistrictConfigService.class) ;

            districtConfigList = mapDistrictConfigService.getDistrictConfigList(flag);

            if(!ListUtils.empty(districtConfigList)){

                resultVo.success(districtConfigList);

            }else{

                resultVo.addError("未查找出集散中心");

            }
            write(resultVo);

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    /**
     * @description 获取地图联系批次展示配置信息
     * @param
     */
    @RequestMapping(value = "/getBatchesConfigList")
    public void getBatchesConfigList(){

        List<BatchesConfig> bcList=null;

        ResultVo resultVo = new ResultVo();

        try{

            mapBatchesConfigService=rpcProxy.create(MapBatchesConfigService.class) ;

            bcList = mapBatchesConfigService.getBatchesConfigList();

            if(!ListUtils.empty(bcList)){

                resultVo.success(bcList);

            }else{

                resultVo.addError("未查找出集散中心");

            }
            write(resultVo);

        }catch(Exception e){

            e.printStackTrace();

        }

    }
}
