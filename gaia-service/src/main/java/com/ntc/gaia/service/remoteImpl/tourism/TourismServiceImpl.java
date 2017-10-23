package com.ntc.gaia.service.remoteImpl.tourism;

import com.ntc.gaia.base.model.tourism.*;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.tourism.TourismService;
import com.ntc.gaia.service.business.tourism.TourismBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Component("TourismService")
public class TourismServiceImpl implements TourismService {
    @Autowired
    private TourismBusiness tourismBusiness;
    @Override
    public List<ArrivalHotel> findArrivalHotel() throws BusinessException {
        List<ArrivalHotel> list = null;
        try{
            list = tourismBusiness.findArrivalHotel();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List<ArrivalScene> findArrivalScene() throws BusinessException {
        List<ArrivalScene> list = null;
        try{
            list = tourismBusiness.findArrivalScene();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public  List<HotelRate> findHotelRate() throws BusinessException {
        List<HotelRate> list = null;
        try{
            list = tourismBusiness.findHotelRate();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List<VisitorRate> findVisitorRate() throws BusinessException {
        List<VisitorRate> list = null;
        try{
            list = tourismBusiness.findVisitorRate();
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }

    @Override
    public List<SceneDynamic> findSceneDynamic(Integer type) throws BusinessException {
        List<SceneDynamic> list = null;
        try{
            list = tourismBusiness.findSceneDynamic(type);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }
        return  list;
    }
}
