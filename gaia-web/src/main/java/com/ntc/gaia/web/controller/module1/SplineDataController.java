package com.ntc.gaia.web.controller.module1;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ntc.gaia.remote.module1.DataSimulateService;
import com.ntc.gaia.remote.module1.DataDynamicSimulateService;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.web.controller.base.BaseController;
/*
*
* @author david
* @date 2017-7-27
*/
@Controller
@RequestMapping(value = "/SplineData")
public class SplineDataController extends BaseController {
    @Autowired
    private RpcProxy rpcProxy;

    private DataSimulateService dataSimulateService;
    private DataDynamicSimulateService dataDynamicSimulateService;

    /**
     * @param model 模型对象
     * @return null
     */
    @RequestMapping(value = "/getSplineData")
    public void getSplineData(Model model) {
        String userId = super.getUCID();//获得客户编号

        try {
            // 远程调用服务层 获取数据
            dataSimulateService = rpcProxy.create(DataSimulateService.class);

            List resultList = dataSimulateService.dataSimulateProvider(userId);

            if (resultList != null) {
                //封装成Json格式
                JSONArray jsonArray;
                jsonArray = JSONArray.fromObject(resultList);
                response.setHeader("Cache-Control", "no-cache");
                response.setContentType("text/json;charset=UTF-8");
                //回传给ajax请求
                PrintWriter out = response.getWriter();
                out.print(jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null;
    }


    /**
     * @param model 模型对象
     * @return null
     */
    @RequestMapping(value = "/getDynamicSplineData")
    public void getDynamicSplineData(Model model) {
        String userId = super.getUCID();//获得客户编号
        try {
            // 远程调用服务层 获取数据
            dataDynamicSimulateService = rpcProxy.create(DataDynamicSimulateService.class);
            List ResultList = dataDynamicSimulateService.dataDynamicSimulateProvider(userId);
            if (ResultList != null) {
                //封装成Json格式
                JSONArray jsonArray;
                jsonArray = JSONArray.fromObject(ResultList);
                response.setHeader("Cache-Control", "no-cache");
                response.setContentType("text/json;charset=UTF-8");
                //回传给ajax请求
                PrintWriter out = response.getWriter();
                out.print(jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null;
    }
}
