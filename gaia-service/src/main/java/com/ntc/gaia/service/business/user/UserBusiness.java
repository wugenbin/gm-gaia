package com.ntc.gaia.service.business.user;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
public interface UserBusiness {

     User findByUserName(String userName) throws BusinessException;

     User findById(Integer id)throws BusinessException;

     List<User> findAllUser(Integer roleType)throws BusinessException;

     Boolean addUser(User user)throws BusinessException;

     Boolean saveUser(User user)throws BusinessException;

     Boolean deleteUser(Integer id)throws BusinessException;

     Boolean saveUserCity(UserCity uc)  throws BusinessException;
     Boolean deleteUserCityByUserId(Integer userId) throws BusinessException;
     Boolean editUserCityByUserId(UserCity uc) throws BusinessException;
}
