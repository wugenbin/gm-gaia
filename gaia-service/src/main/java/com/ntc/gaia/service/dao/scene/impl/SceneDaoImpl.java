package com.ntc.gaia.service.dao.scene.impl;

import com.ntc.gaia.base.model.scene.Scene;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.scene.SceneDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guominchuxing on 2017/8/25.
 */
@Repository
public class SceneDaoImpl extends DaoImpl implements SceneDao {

   public  List<Scene> findScene(String cityName)throws SQLException {
       return super.queryList("findScene",cityName);
   };

    public Boolean saveScene(String cityName,Scene scene)throws SQLException {
        Boolean flag = false;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("cityName",cityName);
        map.put("scene",scene);
        Object obj =  super.add("findScene",map);
        if(obj!=null){
            flag = true;
        }
        return  flag;
    };

    public Scene findSceneBySceneName(String sceneName)throws SQLException {

        return null;
    }

}
