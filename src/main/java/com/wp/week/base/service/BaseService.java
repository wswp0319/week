package com.wp.week.base.service;



import com.wp.week.base.AjaxList;

import java.util.Map;

/**
 * Created by yun on 2017/3/2
 */
public interface BaseService<T> {
    AjaxList add(T instance);

    AjaxList edit(T instance);

    AjaxList delete(T instance);

    AjaxList count(Map<String, Object> paramsMap);

    AjaxList get(Map<String, Object> paramsMap);

    AjaxList list(Map<String, Object> paramsMap);

    AjaxList findOne(Map<String, Object> paramsMap);

//    AjaxList queryPage(Map<String, Object> paramsMap);
}
