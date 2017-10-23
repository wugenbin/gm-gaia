package com.ntc.gaia.web.controller.city;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.Province;
import com.ntc.gaia.base.model.user.TotalData;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.remote.city.CityService;
import com.ntc.gaia.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guominchuxing on 2017/9/7.
 */
@Controller
@RequestMapping(value="/city")
public class CityController extends BaseController {

    protected static Logger log = Logger.getLogger(CityController.class);
    @Autowired
    private RpcProxy rpcProxy;
    private CityService cityService;

    @RequestMapping(value="findCityByProvinceId")
    public void findCityByProvinceId(Integer provinceId){
        ResultVo resultVo = new ResultVo();
        List<City> list = null;
        try {
            cityService = rpcProxy.create(CityService.class);
            list = cityService.findCityByProvinceId(provinceId);
            if(list.size()>0){
                    resultVo.success(list);
            }else{
                    resultVo.addError("未查到数据");
            }
            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value="findAllProvince")
    public void findAllProvince(){
        ResultVo resultVo = new ResultVo();
        List<Province> list = null;
        try {
            cityService = rpcProxy.create(CityService.class);
            list = cityService.findAllProvince();
            if(list.size()>0){
                resultVo.success(list);
            }else{
                resultVo.addError("未查到数据");
            }
            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="findTotalData")
    public void findTotalData(){
        log.info("controller--------------------findTotalData");
        ResultVo resultVo = new ResultVo();
        List<TotalData> list = new ArrayList<TotalData>();
        try {
            cityService = rpcProxy.create(CityService.class);
            list = cityService.findTotalData();
            log.info("controller--------------------findTotalData"+list.size());
            if(list.size()>0){
                resultVo.success(list);
            }else{
                resultVo.addError("未查到数据");
            }

            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
