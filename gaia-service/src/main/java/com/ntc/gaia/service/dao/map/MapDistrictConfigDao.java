package com.ntc.gaia.service.dao.map;

import com.ntc.gaia.base.model.map.DistrictConfig;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author William
 * @date 2017/08/30
 *
 */
public interface MapDistrictConfigDao {

    List<DistrictConfig> getDistrictConfigList(String flag)throws SQLException;

}
