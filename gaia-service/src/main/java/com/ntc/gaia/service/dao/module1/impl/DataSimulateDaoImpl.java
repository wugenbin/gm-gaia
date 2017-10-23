package com.ntc.gaia.service.dao.module1.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ntc.gaia.base.model.module1.PlotYData;
import com.ntc.gaia.base.persist.springmybatis.impl.DaoImpl;
import com.ntc.gaia.service.dao.module1.DataSimulateDao;



/**
 * Created by david on 2017/8/16.
 */
@Repository
public class DataSimulateDaoImpl extends DaoImpl implements DataSimulateDao {

    protected static Logger log = Logger.getLogger(DataSimulateDaoImpl.class);
    @Override
    public List getSimulateData(String userId) throws SQLException {
        //数据的仿真 在dao的实现类方法中进行模拟
   //     log.info("userId-------------------"+userId);

        List<PlotYData> list = new ArrayList<PlotYData>(); //模拟数据
            for (int i = -19; i <= 0; i++) {
                PlotYData pd = new PlotYData();
                Random random = new Random();
                String value0 = String.valueOf(random.nextInt(100));
                String value1 = String.valueOf(random.nextInt(100));
                String value2 = String.valueOf(random.nextInt(100));
                pd.setValue0(value0);
                pd.setValue1(value1);
                pd.setValue2(value2);
                list.add(pd);
            }
          return list;
       // return super.add("pk_xxxx", userId);
    };
}
