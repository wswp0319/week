package com.wp.week.service;

import com.wp.week.mapper.IMapper;
import com.wp.week.utils.AjaxList;
import com.wp.week.utils.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by yun on 2017/3/2
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    public abstract IMapper<T> getMapper();

    @Override
    public AjaxList add(T instance) {
        try {
            Class clazz = instance.getClass();
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods){
                Type[] types = method.getGenericParameterTypes();
                if(types.length == 1 && String.class == types[0] && "setUuid".equals(method.getName())){
                    method.invoke(instance, StringUtil.buildUUID());
                }
            }
            int affectedRowCount = this.getMapper().add(instance);
            if(1 == affectedRowCount){
                return AjaxList.createSuccess("新增数据成功", instance);
            } else {
                return AjaxList.createError("新增数据失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return AjaxList.createError("新增数据失败");
    }

    @Override
    public AjaxList edit(T instance) {
        int affectedRowCount = this.getMapper().edit(instance);
        if(1 == affectedRowCount){
            return AjaxList.createSuccess("更新数据成功", instance);
        } else {
            return AjaxList.createError("更新数据失败");
        }
    }

    @Override
    public AjaxList delete(T instance) {
        int affectedRowCount = this.getMapper().del(instance);
        if(1 == affectedRowCount){
            return AjaxList.createSuccess("更新删除成功", instance);
        } else {
            return AjaxList.createError("更新删除失败");
        }
    }

    @Override
    public AjaxList count(Map<String, Object> paramsMap) {
        return  AjaxList.createSuccess("查询数量成功", this.getMapper().count(paramsMap));
    }

    @Override
    public AjaxList get(Map<String, Object> paramMap) {
        T instance = this.getMapper().selInfo(paramMap);
        if(instance != null) {
            return AjaxList.createSuccess("查询数据成功", instance);
        } else {
            return AjaxList.createError("查询数据为空");
        }
    }

    @Override
    public AjaxList list(Map<String, Object> paramMap) {
        List<T> list = this.getMapper().list(paramMap);
        if(!list.isEmpty()){
            return AjaxList.createSuccess("查询数据成功", list);
        }
        return AjaxList.createError("查询数据为空");
    }

    @Override
    public AjaxList findOne(Map<String, Object> paramMap) {
        List<T> list = this.getMapper().list(paramMap);
        if(!list.isEmpty() && list.size() == 1){
            return AjaxList.createSuccess("查询数据成功", list.get(0));
        }
        return AjaxList.createError("查询数据有误");
    }

//    @Override
//    public AjaxList queryPage(Map<String, Object> paramMap) {
//        PageBounds pageBounds = new PageBounds((Integer) paramMap.get("_pageNum"), (Integer) paramMap.get("_pageSize"));
//        PageList<T> pageList = this.getMapper().queryPage(paramMap, pageBounds);
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        resultMap.put("aaData", pageList);
//        resultMap.put("iTotalRecords", pageList.getPaginator() != null ? pageList.getPaginator().getEndRow() : 0);
//        resultMap.put("iTotalDisplayRecords", pageList.getPaginator() != null ? pageList.getPaginator().getTotalCount() : 0);
//        resultMap.put("sEcho", paramMap.get("_sEcho"));
//        return AjaxList.createSuccess("", resultMap);
//    }
}
