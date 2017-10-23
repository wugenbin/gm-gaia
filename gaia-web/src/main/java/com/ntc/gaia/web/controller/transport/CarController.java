package com.ntc.gaia.web.controller.transport;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.transport.CarInfo;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.remote.transport.CarService;
import com.ntc.gaia.web.controller.base.BaseController;
import com.ntc.gaia.web.controller.websocket.InfoSocketService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author William
 * @date 2017/10/13
 * @description
 */

@Controller
@RequestMapping(value = "/Car")
public class CarController  extends BaseController {

    protected static Logger log = Logger.getLogger(CarController.class);

    @Autowired
    private RpcProxy rpcProxy;

    private CarService carService;

    @Autowired
    private InfoSocketService infoSocketService;

    @RequestMapping(value = "/getInfosByLicenseplate")
    public void getInfosByCarName(String licenseplate){

        CarInfo car=null;

        ResultVo resultVo = new ResultVo();

        try{

            carService=rpcProxy.create(CarService.class) ;

            car = carService.getCarInfoByLicenseplate(licenseplate);

            if(null!=car){

                resultVo.success(car);

            }else{

                resultVo.addError("未查询出该车辆的相关信息");

            }
            write(resultVo);

            JSONObject jsonArray= JSONObject.fromObject(resultVo);

            infoSocketService.sendMessageToClients(jsonArray.toString());

        }catch(Exception e){

            e.printStackTrace();

        }

    }


}
