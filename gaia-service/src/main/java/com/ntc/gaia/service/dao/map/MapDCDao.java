package com.ntc.gaia.service.dao.map;

import com.ntc.gaia.base.model.map.DistributionCenter;

import java.sql.SQLException;
import java.util.List;

/**
 * @author William
 * @date 2017/08/29
 *
 */
public interface MapDCDao {

    List<DistributionCenter> getDCListByCityCode(String cityCode,String centerType)throws SQLException;

}
