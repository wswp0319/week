package com.wp.week.controller;

import com.wordnik.swagger.annotations.ApiParam;
import com.wp.week.model.User;
import com.wp.week.model.UserDto;
import com.wp.week.service.UserService;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/changePwd")
    public String changePwd(
            HttpServletRequest request,
            Model model) {

        HttpSession session = request.getSession();
        model.addAttribute("username", session.getAttribute("username"));   //

        return "page/user/changePwd";
    }

    @RequestMapping("/editPwd")
    @ResponseBody
    public AjaxList editPwd(
            @ApiParam(name = "username", value = "username", required = true) @RequestParam String username,
            @ApiParam(name = "currPwd", value = "currPwd", required = true) @RequestParam String currPwd,
            @ApiParam(name = "newPwd", value = "newPwd", required = true) @RequestParam String newPwd,
            HttpServletRequest request) {

        AjaxList ajaxList = userService.editPwd(username, currPwd, newPwd);
        return ajaxList;
    }

    @RequestMapping("/userInfo")
    public String userInfo(
            HttpServletRequest request) {
        return "page/user/userInfo";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public AjaxList getUsers(
            HttpServletRequest request) {

        AjaxList ajaxList = userService.getUsers();

        return ajaxList;
    }

    @RequestMapping("/resetUserPwd")
    @ResponseBody
    public AjaxList resetUserPwd(
            @ApiParam(name = "userId", value = "id", required = true) @RequestParam Integer userId,
            HttpServletRequest request) {

        AjaxList ajaxList = userService.resetUserPwd(userId);

        return ajaxList;
    }

    @RequestMapping("/addUser")
    public String addUser(
            @ApiParam(name = "userId", value = "id") @RequestParam(required = false) Integer userId,
            Model model) {

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        if (userId != null) {
            userDto = userService.getDailysById(userId);
        }

        model.addAttribute("userDto", userDto);

        return "page/user/addUser";
    }

    @RequestMapping("/addOrUpdateUser")
    public String addOrUpdateUser(
            @ApiParam(name = "userId", value = "userId") @RequestParam(required = false) Integer userId,
            @ApiParam(name = "username", value = "username", required = true) @RequestParam String username,
            @ApiParam(name = "sex", value = "sex", required = true) @RequestParam String sex,
            @ApiParam(name = "userGrade", value = "员工等级", required = true) @RequestParam Integer userGrade,
            @ApiParam(name = "userStatus", value = "userStatus", required = true) @RequestParam Integer userStatus,
            @ApiParam(name = "remark", value = "remark", required = true) @RequestParam String remark,
            Model model) {

        UserDto userDto = new UserDto();
        userDto.setId(userId);
//        userDto.setDept(dept);
userDto.setSex(sex);
        userDto.setRule(userGrade);
        userDto.setStatus(userStatus);
        userDto.setUsername(username);
        userDto.setRemark(remark);

        userService.addOrUpdateUser(userDto);

        return "page/user/allUsers";
    }

    @RequestMapping("/delOneUser")
    @ResponseBody
    public AjaxList delOneUser(
            @ApiParam(name = "userId", value = "id", required = true) @RequestParam Integer userId,
            HttpServletRequest request) {

        AjaxList ajaxList = userService.delOneUser(userId);

        return ajaxList;
    }

}
