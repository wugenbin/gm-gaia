package com.ntc.gaia.service.remoteImpl.user;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.user.UserService;
import com.ntc.gaia.service.business.user.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
@Component("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBusiness userBusiness;

   public  User findByUserName(String userName){
       System.out.println("Service-------"+userName);
       User user = null;
       try{
           user = userBusiness.findByUserName(userName);
           System.out.println("Service-------"+(user==null));
       }catch (BusinessException e){
           LogUtil.error(this.getClass().getName(), e.getErrorMessage());
       }
      return  user;
   };
    public User findById(Integer id){
        System.out.println("Service---------------------id:"+id);
        User user = null;
        try{
            user = userBusiness.findById(id);
            System.out.println("Service---------------------id:"+user.getPassword());
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  user;
    };
    public List<User> findAllUser(Integer roleType){
        List<User> users = null;
        try{
            users = userBusiness.findAllUser(roleType);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  users;
    };


    public Boolean addUser(User user){
        boolean flag = false;
        try{
            flag =  userBusiness.addUser(user);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }

        return true;
    };

    public Boolean saveUser(User user){
        boolean flag = false;
        try{
            flag =  userBusiness.saveUser(user);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return true;
    };
    public Boolean deleteUser(Integer id){
        boolean flag = false;
        try{
            flag =  userBusiness.deleteUser(id);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return true;
    };

    public  Boolean saveUserCity(UserCity uc){
        boolean flag = false;
        try{
            flag =  userBusiness.saveUserCity(uc);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return true;
    };
    public  Boolean deleteUserCityByUserId(Integer userId){
        boolean flag = false;
        try{
            flag =  userBusiness.deleteUserCityByUserId(userId);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return true;
    };
    public  Boolean editUserCityByUserId(UserCity uc){
        boolean flag = false;
        try{
            flag =  userBusiness.editUserCityByUserId(uc);;
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return true;
    };
}
