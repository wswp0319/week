package com.wp.week.mapper;

import com.wp.week.model.RoleMenuDto;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuDto record);

    int insertSelective(RoleMenuDto record);

    RoleMenuDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenuDto record);

    int updateByPrimaryKey(RoleMenuDto record);
}