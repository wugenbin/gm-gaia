package com.ntc.gaia.service.remoteImpl.scene;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.utils.exception.BusinessException;
import com.ntc.gaia.base.utils.log.LogUtil;
import com.ntc.gaia.remote.scene.SceneService;
import com.ntc.gaia.service.business.scene.SceneBusiness;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guominchuxing on 2017/8/25.
 */
public class SceneServiceImpl implements SceneService{
    @Autowired
    private SceneBusiness sceneBusiness;
    @Override
    public List<Scene> findScene(String cityName) {
        List<Scene> secens = null;
        try{
            sceneBusiness.findScene(cityName);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }

        return secens;
    }

    @Override
    public Boolean saveScene(String cityName, Scene scene) {
       boolean flag = false;
        try{
            flag =  sceneBusiness.saveScene(cityName,scene);
        }catch (BusinessException e){
            LogUtil.error(this.getClass().getName(), e.getErrorMessage());
        }

        return flag;
    }
}
