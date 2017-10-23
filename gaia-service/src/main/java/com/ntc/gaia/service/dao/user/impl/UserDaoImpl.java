package com.ntc.gaia.service.dao.user.impl;

import com.ntc.gaia.base.model.user.User;
import com.ntc.gaia.base.model.user.UserCity;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.user.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by guominchuxing on 2017/8/21.
 */
@Repository
public class UserDaoImpl extends DaoImpl implements UserDao{

    protected static Logger log = Logger.getLogger(UserDaoImpl.class);


    public User findByUserName(String userName) throws SQLException{
        System.out.println("Business-------"+userName);
        User user = super.query("findByUserName", userName);
        System.out.println("Business-------"+(user==null));
        return user;

    };
    public User findById(Integer id) throws SQLException{

    //    log.info("dao---------------------id:"+id);
        User user = super.query("findById", id);
      //  log.info("dao---------------------"+user.getPassword());
        return user;
    };
    public List<User> findAllUser(Integer roleType) throws SQLException{
        return super.queryList("findAllUser",roleType);
    };


    public User addUser(User user) throws SQLException{
        return super.add("addUser", user);
    };

    public Integer saveUser(User user) throws SQLException{
        return super.update("saveUser",user) ;
    };
    public Integer deleteUser(Integer id) throws SQLException{
        return super.delete("deleteUser",id);
    };

    public Integer saveUserCity(UserCity uc) throws SQLException{
        return super.add("saveUserCity",uc);
    };
    public  Integer deleteUserCityByUserId(Integer userId) throws SQLException{
        return super.delete("deleteUserCityByUserId",userId);
    };
    public Integer editUserCityByUserId(UserCity uc) throws SQLException{
        return super.update("editUserCityByUserId",uc);
    };
}
