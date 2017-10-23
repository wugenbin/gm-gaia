package com.ntc.gaia.web.controller.user;

import com.ntc.gaia.base.model.base.ResultVo;
import com.ntc.gaia.base.model.user.City;
import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserInfo;
import com.ntc.gaia.base.rpc.hetty.client.RpcProxy;
import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.remote.city.CityService;
import com.ntc.gaia.remote.user.UserService;
import com.ntc.gaia.web.base.constants.ENIPConstants;
import com.ntc.gaia.web.base.vo.SessionLogic;
import com.ntc.gaia.web.controller.base.BaseController;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guominchuxing on 2017/8/21.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    protected static Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private RpcProxy rpcProxy;

    private UserService userService;
    private CityService cityService;

    //private Map<String, User> mapUtils= SessionLogic.getInstance().getUserMaps();

    @RequestMapping(value = "/login")
    public void login(){
//        System.out.println("enter Controller-------------");
        ResultVo resultVo = new ResultVo();
        String userName =  getStrPT("userName");
        String password =  getStrPT("password");
        City city= null;
        Map<String,Object> map = new HashMap<String,Object>();
        try{
//          log.info("userName-------------"+userName);
            userService=rpcProxy.create(UserService.class) ;
            cityService=rpcProxy.create(CityService.class) ;
            User user_t = userService.findByUserName(userName);
//          System.out.println("Controller-------------"+(user_t==null));
            //回传给ajax请求
            if (user_t != null) {
                if(user_t.getPassword().equals(password)){
                    //将用户保存到session
                    putSession(user_t);
                    //查询用户允许查看的城市信息
                    city = cityService.findCityById(user_t.getCityId());
             //     System.out.println("Controller-------------size:"+(cities.size()));
                    map.put("user",user_t);
                    map.put("city",city);
                    resultVo.success(map);
                }else{
                    resultVo.addError("用户名或密码错误");
                }
            }else{
                resultVo.addError("用户不存在");
            }
            write(resultVo);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    @RequestMapping(value = "/deleteUser")
    /*新增或编辑用户*/
    public void deleteUser() {
        String userId  = getStrPT("id");
        ResultVo resultVo = new ResultVo();
        boolean flag = false;
        try {
            userService = rpcProxy.create(UserService.class);
            if(StringUtil.notEmpty(userId)){
               flag = userService.deleteUser(Integer.parseInt(userId));
            //    userService.deleteUserCityByUserId(Integer.parseInt(userId));  //删除用户城市表该用户对应的数据
               if(flag){
                     resultVo.success(null);
               }else{
                     resultVo.addError("删除用户失败");
               }
            }else {
               resultVo.addError("未指定要删除的用户");
             }
            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/checkUserName")
    /* 验证userName是否已存在*/
    public void checkUserName(String userName){
        userService=rpcProxy.create(UserService.class) ;
        ResultVo resultVo = new ResultVo();
        if(StringUtil.notEmpty(userName)){
            User user = userService.findByUserName(userName);
            if(user!=null){
                resultVo.success(null);
            }else{
                resultVo.addError("用户不存在");
            }
        }
        write(resultVo);
    }

    @RequestMapping(value = "/saveUser")
    /*新增或编辑用户*/
    public void saveUser(UserInfo userInfo) {
        ResultVo resultVo = new ResultVo();
        boolean flag=false;
        String userName = userInfo.getUserName();
        String password = userInfo.getPassword();
        User user =  null;
        List<User> list = new ArrayList<User>();
        try {
            userService = rpcProxy.create(UserService.class);
                      //  log.info("userId--------------------"+userId);
                        User user_t = userService.findByUserName(userName);
                        if (user_t != null) {
                            resultVo.addError("用户名已存在");
                        } else {
                            Integer userId = userInfo.getId();
                            if(userId != null && userId>0 ){
                                user = new User (userId,userName,password,userInfo.getCityId(),userInfo.getProvinceId());
                             // UserCity uc = new UserCity(userId,userInfo.getCityId());
                                //userId不为空则判断为编辑用户
                                flag = userService.saveUser(user); //修改用户名和密码
                                // 修改用户城市表数据
                              //  userService.editUserCityByUserId(uc);
                                if(flag){
                                    list = userService.findAllUser(userInfo.getRoleType());
                                    resultVo.success(list);
                                }else{
                                    resultVo.addError("编辑用户失败");
                                }
                            }else{
                                //userId为空则为新增用户
                                user = new User (userName,password,userInfo.getCityId(),userInfo.getProvinceId(),
                                        userInfo.getRoleType(),userInfo.getRoleName());
                               // UserCity uc = new UserCity(userId,userInfo.getCityId());
                                flag = userService.addUser(user); //新增用户
                                if (flag) {
                                    list = userService.findAllUser( userInfo.getRoleType());
                                    resultVo.success(list);
                                } else {
                                    resultVo.addError("添加用户失败");
                                }
                            }

                        }
            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/editUser")
    /*修改密码  修改密码时用户名不能变*/
    public void editUser(UserInfo userInfo) {
        ResultVo resultVo = new ResultVo();
        boolean flag=false;
        User user = new User();
        try {
            userService = rpcProxy.create(UserService.class);
            if(userInfo!=null){
                Integer userId = userInfo.getId();
                String oldPassword =   userInfo.getOldPassword();
                if(StringUtil.notEmpty(String.valueOf(userId)) && userId>0){
                    //userId不为空则判断为编辑用户
                    User  user_t = userService.findById(userId);
                    System.out.println("Controller---------------------:"+(user_t==null));
                    if(user_t != null){
                     //   log.info("UserName-------"+user_t.getUserName());
                        if(user_t.getPassword().equals(oldPassword)){
                            user.setId(userId);
                            user.setUserName(userInfo.getUserName());
                            user.setPassword(userInfo.getNewPassword());
                            flag = userService.saveUser(user); //修改密码
                            if(flag){
                                resultVo.success(null);
                            }else{
                                resultVo.addError("密码修改失败");
                            }
                        }else{
                            resultVo.addError("原密码不正确");
                        }

                    }else{
                        resultVo.addError("根据id未查到用户");
                    }
                }else{
                    resultVo.addError("用户ID不能为空");
                }
            }else{
                resultVo.addError("用户信息不能为空");
            }

             write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/findAllUser")
    /*查询所有用户*/
    public void findAllUser(Integer roleType) {
    //    Integer roleType = 1;
        log.info("roleType-------------------------------"+roleType);
        ResultVo resultVo = new ResultVo();
        List list = new ArrayList();
        boolean flag = false;
        try {
            userService = rpcProxy.create(UserService.class);
            cityService = rpcProxy.create(CityService.class);
            List<User> users = userService.findAllUser(roleType);
            if(users.size()>0){
                for(User user :users){
                    Map<String,Object> map = new HashMap<String,Object>();
                //    log.info("cityId----------------------"+user.getCityId());
                    City city = cityService.findCityById(user.getCityId());
                    map.put("user",user);
                    map.put("city",city);
                    list.add(map);
                }
                resultVo.success(list);
            }else{
                    resultVo.addError("未查到用户");
            }
            write(resultVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/outLogin")
    /*用户登出 */
    public void outLogin(){
        ResultVo resultVo = new ResultVo();
        Map<String, User> mapUtils= SessionLogic.getInstance().getUserMaps();
        String cid  = super.getUCID();//获得session 中的userId
        request.removeAttribute(ENIPConstants.US_SN);
        session.removeAttribute(ENIPConstants.LOGIN_SESSION_KEY);
        session.invalidate();
        mapUtils.remove(cid);
        resultVo.success(null);
        write(resultVo);
    }

    @RequestMapping(value = "/test")
    /*此方法为测试方法 */
    public void test(){
    //    cityService=rpcProxy.create(CityService.class) ;
       // userService=rpcProxy.create(UserService.class) ;
       City  city = cityService.findCityByCityName("湖州");
       // List<Role>  list = roleService.findRoleByUserName("rack");
      //  User  list = userService.findByUserName("rack");

        try {
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject(city);
            response.setHeader("Cache-Control", "no-cache");
            response.setContentType("text/json;charset=UTF-8");
            out.print(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
