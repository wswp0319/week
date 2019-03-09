package com.wp.week.base.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {
    public MapUtil() {
    }

    public static Map<String, Object> buildMap() {
        return new HashMap();
    }

    public static Map<String, Object> buildMap(int length) {
        return new HashMap(length);
    }

    public static Map<String, Object> buildPageMap() {
        HashMap pageMap = new HashMap();
        pageMap.put("page", 0);
        pageMap.put("pageSize", 10);
        return pageMap;
    }

    public static Map<String, Object> buildPageMap(int pageSize) {
        HashMap pageMap = new HashMap();
        pageMap.put("page", 0);
        pageMap.put("pageSize", pageSize);
        return pageMap;
    }

    public static String convertStr(Map<String, ?> map) {
        StringBuffer sb = new StringBuffer();
        Iterator iter = map.entrySet().iterator();

        while(iter.hasNext()) {
            Entry element = (Entry)iter.next();
            Object strKey = element.getKey();
            if (!"page".equals(String.valueOf(strKey)) && !"pageSize".equals(String.valueOf(strKey))) {
                String strObj = String.valueOf(element.getValue());
                sb.append(strKey).append("=").append(strObj).append("&");
            }
        }

        if (sb.length() > 0) {
            return sb.toString().substring(0, sb.length() - 1);
        } else {
            return sb.toString();
        }
    }

    private static String getStr(String[] args) {
        String str = "";

        for(int i = 0; i < args.length; ++i) {
            str = str + args[i] + ",";
        }

        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }
}
