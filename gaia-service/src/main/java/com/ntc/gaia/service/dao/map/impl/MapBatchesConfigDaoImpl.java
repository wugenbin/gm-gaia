package com.ntc.gaia.service.dao.map.impl;

import com.ntc.gaia.base.model.map.BatchesConfig;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.map.MapBatchesConfigDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/09/01
 *
 */
@Repository
public class MapBatchesConfigDaoImpl extends DaoImpl implements MapBatchesConfigDao {

    @Override
    public List<BatchesConfig> getBatchesConfigList() throws SQLException {

        List<BatchesConfig> list = super.queryList("getBatchesConfigList");

        return list;
    }
}
