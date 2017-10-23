package com.ntc.gaia.service.dao.tourism;

import com.ntc.gaia.base.model.tourism.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public interface TourismDao {
    List<ArrivalHotel> findArrivalHotel() throws SQLException;
    List<ArrivalScene> findArrivalScene() throws SQLException;
    List<HotelRate> findHotelRate() throws SQLException;
    List<VisitorRate> findVisitorRate() throws SQLException;
    List<SceneDynamic> findSceneDynamic(Integer type) throws SQLException;

}
