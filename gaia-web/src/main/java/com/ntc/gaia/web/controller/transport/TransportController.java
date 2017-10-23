package com.ntc.gaia.web.controller.transport;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.tourism.TourismInfo;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.remote.transport.TransportService;
import com.ntc.gaia.web.controller.base.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Controller
@RequestMapping(value = "/transport")
public class TransportController extends BaseController{
    @Autowired
    private RpcProxy rpcProxy;
    private TransportService transportService;

    @RequestMapping(value="/findData")
    public void findData(TourismInfo tourismInfo){
        log.info("params------"+ JSONObject.fromObject(tourismInfo));
        ResultVo resultVo = new ResultVo();
        List list = new ArrayList();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //验证参数
                boolean flag = checkTourismInfo(tourismInfo);
                if(flag){
                    transportService = rpcProxy.create(TransportService.class);
                    map = getTransportData(transportService,tourismInfo);
                    if(map.size()>0){
                            resultVo.success(map);
                    }else{
                        resultVo.addError("未查到数据");
                    }
                }else{
                    resultVo.addError("参数错误");
                }
               write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String,Object> getTransportData(TransportService transportService,TourismInfo tourismInfo){
     /*  //arrivalPort,trafficRate,sceneLink,passagerSort,enterpotDaba */

        List list1 = new ArrayList();
        List list2 = new ArrayList();
        Map<String,Object> map = new HashMap<String,Object>();
        String content = tourismInfo.getContent();
        try{
            if("arrivalPort".equals(content)){
                list1 = transportService.findArrivalPassager();
                list2 = transportService.findArrivalPassager();
                map.put("data1",list1);
                map.put("data2",list2);
            }else if("trafficRate".equals(content)){
                list1 = transportService.findTrafficRate();
                list2 = transportService.findTrafficRate();
                map.put("data1",list1);
                map.put("data2",list2);
            }else if("sceneLink".equals(content)){
                Map<String,Object> map1 = transportService.findPassagerScene();
                Map<String,Object> map2 = transportService.findPassagerScene();
                map.put("data1",map1);
                map.put("data2",map2);

            }else if("passagerSort".equals(content)){
                list1 = transportService.findPassagerSort();
                list2 = transportService.findPassagerSort();
                map.put("data1",list1);
                map.put("data2",list2);

            }else if("enterpotDaba".equals(content)){
                list1 = transportService.findEnterpotDaba(tourismInfo.getType());
                map.put("data1",list1);
                map.put("data2","");
            }else if("trafficPeak".equals(content)){
                list1 = transportService.findTrafficPeak();
                list2 = transportService.findTrafficPeak();
                map.put("data1",list1);
                map.put("data2",list2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public boolean checkTourismInfo(TourismInfo tourismInfo){
        //arrivalPort,trafficRate,sceneLink,passagerSort,enterpotDaba,trafficPeak
        boolean flag = false;
        String content = tourismInfo.getContent()== null ? "":tourismInfo.getContent();
        Integer roleType = tourismInfo.getRoleType()== null ? 0:tourismInfo.getRoleType();
        if((content.equals("arrivalPort")
                || content.equals("trafficRate")
                || content.equals("sceneLink")
                || content.equals("passagerSort")
                || content.equals("enterpotDaba")
                || content.equals("trafficPeak"))
                && roleType==1 ){
            //trafficPeak
            flag = true;
        }
        return flag;
    }


}
