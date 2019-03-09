package com.wp.week.mapper;

import com.wp.week.model.MenuDto;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuDto record);

    int insertSelective(MenuDto record);

    MenuDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuDto record);

    int updateByPrimaryKey(MenuDto record);

    List<MenuDto> getMenusByUid(Map<String,Object> params);
}