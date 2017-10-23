package com.ntc.gaia.web.controller.base;

import com.ntc.gaia.base.model.user.User;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.UUID;

import com.ntc.gaia.web.base.constants.ENIPConstants;
import com.ntc.gaia.base.utils.tools.DateUtil;
import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.web.base.vo.CSessionBean;
import com.ntc.gaia.web.base.vo.SessionLogic;
/**
 * SpringMVC UI控制代码公共类
 * 从request、response、session对象中获取与用户及会话有关的信息
 *
 * @author David
 * @date 2017-07-20
 */
public abstract class BaseController {

    protected static Logger log = Logger.getLogger(BaseController.class);

    // 公共的request对象
    protected HttpServletRequest request;

    // 公共的respone对象
    protected HttpServletResponse response;

    // 公共的session对象
    protected HttpSession session;

//    // 文件服务器地址配置
//    @Value("#{configProperties['fileSvrBaseUrl']}")
//    protected String fileSvrBaseUrl;
//
//    // 项目域名地址
//    @Value("#{configProperties['domainHost']}")
//    protected String domainHost;

    /**
     * 注入request ,response ,session
     *
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setHttpContext(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    //将结果对象回传给Ajax
    public void write(Object resultVo){
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        try{
            PrintWriter out = response.getWriter();
            // JSONArray jsonArray;
            JSONObject jsonArray= JSONObject.fromObject(resultVo);
            //回传给ajax请求
            out.print(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得UUID随机数
     *
     * @return
     */
    protected String getUUID() {

        return UUID.randomUUID().toString();
    }

    /**
     * 根据Spring框架请求url，获取从UI传递来的封装在request中的对应key属性的属性值message
     *
     * @param key
     * @return
     */
    protected String getSpringMSG(String key) {

        String msg = "";
        if (StringUtil.notEmpty(key)) {

            RequestContext context = new RequestContext(request);
            msg = context.getMessage(key);
        }

        return msg;
    }

    /**
     * 两种方式（一种是从request对象中找，一种是从session对象中找）获得登陆用户的CSessionBean
     *
     * @return
     */
    protected User getSessionUC() {
        // 定义会话对象
        User user = null;

        // 先获得参数中会话键,如果没有再查询会话ID
        //从请求request中通过匹配属性ENIPContants.US_SN获得其属性值，即cid
        String tSN = getStrPT(ENIPConstants.US_SN);
        if (StringUtil.notEmpty(tSN)) {
            user = (User) SessionLogic.getInstance().getLoginUC(tSN);
        } else {
            //如果（tSN即cid）cid为空，则从session的属性ENIPContants.LOGIN_SESSION_KEY键值获得登陆用户的CSessionBean对象
            user = (User) session.getAttribute(ENIPConstants.LOGIN_SESSION_KEY);
            if (user != null) {
                // 如果request中的cid传递丢失，则对request的属性进行校正
                //request.setAttribute(ENIPConstants.US_SN, eS.getUID());
                request.setAttribute(ENIPConstants.US_SN, user.getId());
            }
        }
        return user;
    }

    /**
     * 获取登陆用户的会话SN即 uid
     *
     * @return UID 会话值
     */
    protected String getSn() {

        User user = getSessionUC();
        if (user != null) {
            return String.valueOf(user.getId());
        }
        return "";
    }

    /**
     * 获得登陆用户的cid，即客户编号
     *
     * @return operatorId (Integer型)
     */
    protected String getUCID() {

        String userId = "";
        User user = getSessionUC();
        if (user != null) {
            userId = String.valueOf(user.getId());
        }

        return userId;
    }


    /**
     * 获得登陆用户的用户名
     *
     * @return 如{2014-11-10 10:43:40}
     */
    protected String operateUC() {

        User user = getSessionUC();
        if (user != null) {
            return user.getUserName();
        }
        return "";
    }


    /**
     * 获得创建时间
     *
     * @return 如{2014-11-10 10:43:40}
     */
    protected static String operateTime() {

        return DateUtil.getYMDHMS();
    }

    /**
     * 获取请求的参数（返回String 类型），根据paraMttr这个属性，从request中匹配获取对应的属性值
     **/
    protected String getStrPT(String paramAttr) {
        return ServletRequestUtils.getStringParameter(request, paramAttr, "").trim();
    }

    /**
     * 获取请求的参数（返回Integer类型），根据paraMttr这个属性，从request中匹配获取对应的属性值
     **/
    protected Integer getIntPT(String paramAttr) {

        return ServletRequestUtils.getIntParameter(request, paramAttr, 0);
    }

    /**
     * 获取请求的参数（返回Double类型），根据paraMttr这个属性，从request中匹配获取对应的属性值
     **/
    protected Double getDbPT(String paramAttr) {

        return ServletRequestUtils.getDoubleParameter(request, paramAttr, 0.0);
    }

    /**
     * 反射获取对象，获取的是把request传递的名/值对，封装起来的bean对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T getParamByBean(Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException e) {
            log.debug(e.getMessage());
        } catch (IllegalAccessException e) {
            log.debug(e.getMessage());
        }

        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String key = enums.nextElement();
            String val = request.getParameter(key);

            if (StringUtil.notEmpty(val)) {
                //ReflectUtils.setFieldValueIgnoreCase(bean, key, val);
            }
        }
        return bean;
    }

    //判断用户是否已登录
    public boolean isLogin(){
        boolean flag = false;
        String cid  = getUCID();//获得session 中的userId
        if(StringUtil.notEmpty(cid)){
            flag = true;
        }
        return flag;
    }
    //将用户信息保存到session
    public void putSession(User user){
        //将用户信息保存到session
        Map<String, User> mapUtils= SessionLogic.getInstance().getUserMaps();;
        try{
            request.setAttribute(ENIPConstants.US_SN,String.valueOf(user.getId()));
            session.setAttribute(ENIPConstants.LOGIN_SESSION_KEY,user);
            mapUtils.put(String.valueOf(user.getId()),user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
