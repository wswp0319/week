package com.wp.week.service;

import com.wp.week.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class RoleMenuService {

    @Autowired
    private UserMapper userMapper;


}
