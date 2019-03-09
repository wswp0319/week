package com.wp.week.mapper;

import com.wp.week.model.UserDto;
import com.wp.week.model.UserVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);

    List<UserDto> getUserInfo(Map<String, Object> map);

    List<UserVO> getUsers();

    UserDto getUserByName(String username);
}