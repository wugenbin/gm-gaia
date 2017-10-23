package com.ntc.gaia.service.dao.map.impl;

import com.ntc.gaia.base.model.map.DistributionCenter;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.map.MapDCDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author William
 * @date 2017/08/30
 *
 */
@Repository
public class MapDCDaoImpl extends DaoImpl implements MapDCDao{


    @Override
    public List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType) throws SQLException {

        Map<String,String> map=new HashMap<String,String>();

        map.put("cityCode",cityCode);

        map.put("centerType",centerType);

        List<DistributionCenter> list = super.queryList("getDCListByCityCode",map);

        return list;
    }
}
