package com.ntc.gaia.remote.user;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
public interface UserService {

     User findByUserName(String userName);
     User findById(Integer id);
     List<User> findAllUser(Integer roleType);

     Boolean addUser(User user);
     Boolean saveUser(User User);
     Boolean deleteUser(Integer id);

     Boolean saveUserCity(UserCity uc);
     Boolean deleteUserCityByUserId(Integer userId);
     Boolean editUserCityByUserId(UserCity uc);
}
