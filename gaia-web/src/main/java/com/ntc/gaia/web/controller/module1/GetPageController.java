package com.ntc.gaia.web.controller.module1;

import com.ntc.gaia.web.controller.base.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author david
 * @date 2017-7-27
 */
@Controller
public class GetPageController extends BaseController{

    protected static Logger log = Logger.getLogger(GetPageController.class);
//页面请求的地址在这里，即在页面地址栏输入：http://localhost:8081/getpage
   @RequestMapping("/getpage")
    public String getPage(Model model) {
        return "/module1/splinechart";
    }

    @RequestMapping("/dataview")
    public void dataview(Model model) {
      try{
          String url = "page/gaia/index.html";
       //   url------------/gaia-web/dataview/page/gaia/index.html
       //   /gaia-web/page/gaia/index.html
          log.info("url------------"+url);
          response.sendRedirect(url);
         // request.getRequestDispatcher(url).forward(request,response);
      }catch (IOException e){
          e.printStackTrace();
      }

    }

/*  @RequestMapping("/dataview2")
    public String getPage2(Model model) {

        return "/index";
    }*/
}
