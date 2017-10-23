package com.ntc.gaia.service.dao.map.impl;

import com.ntc.gaia.base.model.map.DistrictConfig;
import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.map.MapDistrictConfigDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/08/30
 *
 */
@Repository
public class MapDistrictConfigDaoImpl extends DaoImpl implements MapDistrictConfigDao {

    @Override
    public List<DistrictConfig> getDistrictConfigList(String flag) throws SQLException {

        List<DistrictConfig> list= super.queryList("getDistrictConfigList",flag);

        return list;

    }
}
