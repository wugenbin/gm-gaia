package com.ntc.gaia.service.dao.map;

import com.ntc.gaia.base.model.map.BatchesConfig;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 *
 */
public interface MapBatchesConfigDao {

    List<BatchesConfig> getBatchesConfigList()throws SQLException;

}
