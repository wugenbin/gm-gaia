package com.ntc.gaia.service.dao.map;



import com.ntc.gaia.base.model.scene.Scene;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author william
 * @date 2017/08/26
 *
 */
public interface MapSceneryDao {

    List<Scene> getSceneryListByCityCode(String cityCode)throws SQLException;

}
