package com.ntc.gaia.remote.tourism;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.utils.exception.BusinessException;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public interface TourismService {
    List<ArrivalHotel> findArrivalHotel() throws BusinessException;
    List<ArrivalScene> findArrivalScene() throws BusinessException;
    List<HotelRate> findHotelRate() throws BusinessException;
    List<VisitorRate> findVisitorRate() throws BusinessException;
    List<SceneDynamic> findSceneDynamic(Integer type) throws BusinessException;
}
