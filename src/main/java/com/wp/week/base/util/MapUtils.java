package com.wp.week.base.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */
public class MapUtils extends MapUtil {
    public static Map<String, Object> createDefault(String key, Object value){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value);
        return map;
    }
}
