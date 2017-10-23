package com.ntc.gaia.service.dao.user;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
public interface UserDao {

    User findByUserName(String userName) throws SQLException;

    User findById(Integer id) throws SQLException;

    List<User> findAllUser(Integer roleType) throws SQLException;

    User addUser(User user) throws SQLException;

    Integer saveUser(User user) throws SQLException;

    Integer deleteUser(Integer id) throws SQLException;

    Integer saveUserCity(UserCity uc)  throws SQLException;
    Integer deleteUserCityByUserId(Integer userId)  throws SQLException;
    Integer editUserCityByUserId(UserCity uc) throws SQLException;

}
