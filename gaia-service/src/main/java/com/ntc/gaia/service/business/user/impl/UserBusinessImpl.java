package com.ntc.gaia.service.business.user.impl;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.exception.SystemErrorCode;
import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.service.business.user.UserBusiness;
import com.ntc.gaia.service.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
@Service("UserBusiness")
public class UserBusinessImpl implements UserBusiness{

    @Autowired
    private UserDao userDao;

    public User findByUserName(String userName)throws BusinessException {
        System.out.println("Business-------"+userName);
         try {
             User user = userDao.findByUserName(userName);
             System.out.println("Business-------"+(user==null));
             return user;
         }catch (SQLException e){
             throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
         }

    };
    public User findById(Integer id)throws BusinessException{
        System.out.println("Business---------------------id:"+id);
        try {
            User user = userDao.findById(id);
            System.out.println("Business---------------------id:"+user.getPassword());
            return user;
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    };
    public List<User> findAllUser(Integer roleType)throws BusinessException{
        try {
            List<User> users = userDao.findAllUser(roleType);
            return users;
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
    };


    public Boolean addUser(User user)throws BusinessException{
        boolean flag=false;
        try {
            User user_t = userDao.addUser(user);
            if(user_t !=null){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };

    public Boolean saveUser(User user)throws BusinessException{
        boolean flag=false;
        try {
            Integer n = userDao.saveUser(user);
            if(n>0){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };
    public Boolean deleteUser(Integer id)throws BusinessException{
        boolean flag=false;
        try {
            Integer n = userDao.deleteUser(id);
            if(n>0){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };

    public Boolean saveUserCity(UserCity uc)throws BusinessException{
        boolean flag=false;
        try {
            Integer n = userDao.saveUserCity(uc);
            if(n>0){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };
    public Boolean deleteUserCityByUserId(Integer userId) throws BusinessException{
        boolean flag=false;
        try {
            Integer n = userDao.deleteUserCityByUserId(userId);
            if(n>0){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };
    public Boolean editUserCityByUserId(UserCity uc) throws BusinessException{
        boolean flag=false;
        try {
            Integer n = userDao.editUserCityByUserId(uc);
            if(n>0){
                flag= true;
            }
        }catch (SQLException e){
            throw new BusinessException(SystemErrorCode.DBCode.EXEC_DATA_ERROR, e.getMessage());
        }
        return flag;
    };
}
