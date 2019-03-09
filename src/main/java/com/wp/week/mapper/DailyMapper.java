package com.wp.week.mapper;

import com.wp.week.model.DailyDto;

import java.util.List;
import java.util.Map;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DailyDto record);

    int insertSelective(DailyDto record);

    DailyDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DailyDto record);

    int updateByPrimaryKey(DailyDto record);

    List<DailyDto> getDailysByRole(Map<String,Object> map);

    List<Map<String, Object>> getDailysExcel(Map<String,Object> map);

}