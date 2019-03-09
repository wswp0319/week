package com.wp.week.service;

import com.wp.week.mapper.UserMapper;
import com.wp.week.model.UserDto;
import com.wp.week.model.UserVO;
import com.wp.week.utils.AESUtils;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public AjaxList getUserInfo(String username, String password) {

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<UserDto> userDtos = userMapper.getUserInfo(map);
        if (userDtos != null && userDtos.size() > 0) {
            if (userDtos.size() > 1) {
                return AjaxList.createError("登录名重复,请联系管理员");
            }
            UserDto userDto = userDtos.get(0);
            //0：封号
            if (userDto.getStatus() == 0) {
                return AjaxList.createError("已被封号,请联系管理员");
            }

            String encryptPwd = AESUtils.encrypt(password);
            if (encryptPwd.equals(userDto.getPassword())) {
                return AjaxList.createSuccess("登陆成功", userDto);
            }
            return AjaxList.createError("密码错误");
        }
        return AjaxList.createError("账号不存在");
    }

    public AjaxList getUsers() {

        List<UserVO> users = userMapper.getUsers();

        return AjaxList.createSuccess("获取成功", users);
    }

    public UserDto getDailysById(Integer userId) {

        UserDto userDto = userMapper.selectByPrimaryKey(userId);
        return userDto;
    }

    public void addOrUpdateUser(UserDto userDto) {

        Integer id = userDto.getId();
        Date date = new Date();
        if (id == null) {
            UserDto userByName = userMapper.getUserByName(userDto.getUsername());
            if (userByName != null) {
                return;
            }

            String encryptPwd = AESUtils.encrypt("123456");
            userDto.setPassword(encryptPwd);

            userDto.setCreateTime(date);
            userDto.setUpdateTime(date);
            userMapper.insert(userDto);
        } else {
            userDto.setUpdateTime(date);
            userMapper.updateByPrimaryKey(userDto);
        }
    }

    public AjaxList delOneUser(Integer userId) {
        System.err.println("--------------"+userId);
        userMapper.deleteByPrimaryKey(userId);


        return AjaxList.createSuccess("删除成功");
    }


    public AjaxList editPwd(String username, String currPwd, String newPwd) {

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<UserDto> userDtos = userMapper.getUserInfo(map);
        UserDto userDto = userDtos.get(0);

        String currentPwd = AESUtils.encrypt(currPwd);

        if (currentPwd.equals(userDto.getPassword())) {
            userDto.setPassword(AESUtils.encrypt(newPwd));
            userMapper.updateByPrimaryKeySelective(userDto);
            return AjaxList.createSuccess("修改密码成功");
        }
        return AjaxList.createError("原密码错误,请重新输入");

    }


    public UserDto geUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    public AjaxList resetUserPwd(Integer userId) {

        UserDto userDto = userMapper.selectByPrimaryKey(userId);
        userDto.setPassword(AESUtils.encrypt("123456"));
        userMapper.updateByPrimaryKey(userDto);
        return AjaxList.createSuccess("密码重置成功");
    }
}
