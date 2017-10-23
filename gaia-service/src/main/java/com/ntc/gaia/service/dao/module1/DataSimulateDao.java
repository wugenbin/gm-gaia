package com.ntc.gaia.service.dao.module1;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by david on 2017/8/16.
 */
public interface DataSimulateDao {
    List getSimulateData(String userId) throws SQLException;

}
