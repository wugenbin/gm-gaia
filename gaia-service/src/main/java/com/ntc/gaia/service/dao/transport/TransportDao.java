package com.ntc.gaia.service.dao.transport;

import com.ntc.gaia.base.model.transport.ArrivalPassager;
import com.ntc.gaia.base.model.transport.EnterpotDaba;
import com.ntc.gaia.base.model.transport.PassagerSort;
import com.ntc.gaia.base.model.transport.TrafficRate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public interface TransportDao {
    List<ArrivalPassager> findArrivalPassager()throws SQLException;
    List<EnterpotDaba> findEnterpotDaba(Integer type)throws SQLException;
    Map<String,Object> findPassagerScene()throws SQLException;
    List<PassagerSort> findPassagerSort() throws SQLException;
    List<TrafficRate> findTrafficRate() throws SQLException;

    List findTrafficPeak() throws SQLException;

}
