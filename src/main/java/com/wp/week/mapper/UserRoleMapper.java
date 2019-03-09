package com.wp.week.mapper;

import com.wp.week.model.UserRoleDto;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleDto record);

    int insertSelective(UserRoleDto record);

    UserRoleDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleDto record);

    int updateByPrimaryKey(UserRoleDto record);
}