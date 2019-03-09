package com.wp.week.mapper;

import com.wp.week.model.RoleDto;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleDto record);

    int insertSelective(RoleDto record);

    RoleDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleDto record);

    int updateByPrimaryKey(RoleDto record);
}