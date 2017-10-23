package com.ntc.gaia.service.dao.map.impl;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.map.MapSceneryDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author  William
 * @date 2017/08/26
 */
@Repository
public class MapSceneryDaoImpl extends DaoImpl implements MapSceneryDao {

    @Override
    public List<Scene> getSceneryListByCityCode(@Param("cityCode")String cityCode) throws SQLException {

        List<Scene> list=  super.queryList("getSceneryListByCityCode",cityCode);

        return list;

    }
}
