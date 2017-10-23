package com.ntc.gaia.web.controller.tourism;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.tourism.TourismInfo;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.remote.tourism.TourismService;
import com.ntc.gaia.web.controller.base.BaseController;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/15 0015.
 * 旅委controller类
 */
@Controller
@RequestMapping(value="/tourism")
public class TourismController extends BaseController{
    protected static Logger log = Logger.getLogger(TourismController.class);

    @Autowired
    private RpcProxy rpcProxy;
    private TourismService tourismService;

    @RequestMapping(value="/findData")
    public void findData(TourismInfo tourismInfo){
        log.info("params------"+ JSONObject.fromObject(tourismInfo));
        ResultVo resultVo = new ResultVo();
    //    List list = new ArrayList();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //验证参数
            boolean flag = checkTourismInfo(tourismInfo);
            if(flag){
                    tourismService = rpcProxy.create(TourismService.class);
                    map = getTourismData(tourismService,tourismInfo);
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

    public  Map<String,Object> getTourismData(TourismService tourismService,TourismInfo tourismInfo){
     /* arrivalScene,visitorRate,arrivalHotel,hotelRate ,sceneDynamic  */
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        Map<String,Object> map = new HashMap<String,Object>();
        String content = tourismInfo.getContent();
        try{
            if("arrivalScene".equals(content)){
                list1 = tourismService.findArrivalScene();
                list2 = tourismService.findArrivalScene();
            }else if("visitorRate".equals(content)){
                list1 = tourismService.findVisitorRate();
                list2 = tourismService.findVisitorRate();

            }else if("arrivalHotel".equals(content)){
                list1 = tourismService.findArrivalHotel();
                list2 = tourismService.findArrivalHotel();

            }else if("hotelRate".equals(content)){
                list1 = tourismService.findHotelRate();
                list2 = tourismService.findHotelRate();

            }else if("sceneDynamic".equals(content)){
                list1 = tourismService.findSceneDynamic(tourismInfo.getType());
              //  list2 = tourismService.findSceneDynamic(tourismInfo.getType());
            }
            map.put("data1",list1);
            map.put("data2",list2==null ? "":list2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public boolean checkTourismInfo(TourismInfo tourismInfo){
        boolean flag = false;
        String content = tourismInfo.getContent()== null ? "":tourismInfo.getContent();
        Integer roleType = tourismInfo.getRoleType()== null ? 0:tourismInfo.getRoleType();
        if((content.equals("arrivalScene")
           || content.equals("visitorRate")
           || content.equals("arrivalHotel")
           || content.equals("hotelRate")
           || content.equals("sceneDynamic"))
            && roleType==2 ){
            flag = true;
        }
        return flag;
    }
}
