package com.ntc.gaia.base.utils.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class JsonUtils {

    public String toJson(Object obj){
        List list = new ArrayList();
       // JSONArray array = null;

        if(obj!=null){
            list.add(obj);
         //   array  =  JSONArray.fromObject(list);
         //   return array;
        }
        return null;
    }
}
