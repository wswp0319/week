package com.wp.week.controller;

import com.wordnik.swagger.annotations.ApiParam;
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

@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String login(
            HttpServletRequest request,
            Model model) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if ( username== null) {
            return "redirect:login.html";
        }
        model.addAttribute("username", username);
        return "index";
    }

    @RequestMapping("/join")
    @ResponseBody
    public AjaxList join(
            @ApiParam(name = "username", value = "用户名", required = true) @RequestParam String username,
            @ApiParam(name = "password", value = "密码", required = true) @RequestParam String password,
            HttpServletRequest request) {

        AjaxList ajaxList = userService.getUserInfo(username,password);
        if (ajaxList.isSuccess()) {
            UserDto userDto = (UserDto) ajaxList.getData();
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("dept",userDto.getDept());
            session.setAttribute("rule",userDto.getRule());
            session.setAttribute("userId",userDto.getId());
        }
        return ajaxList;
    }


    @RequestMapping("/goLogin")
    public String goLogin(
            HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("dept");
        session.removeAttribute("rule");

        return "redirect:login.html";
    }


    @RequestMapping("/tables")
    public String goTables(
            @ApiParam(name = "username", value = "用户名", required = true) @RequestParam String username,
            @ApiParam(name = "pwd", value = "密码", required = true) @RequestParam String pwd,
            HttpServletRequest request) {
        return "index";
    }

    @RequestMapping("/news")
    public String news(
            HttpServletRequest request) {
        return "page/news/newsList";
    }
    @RequestMapping("/plantInfos")
    public String plantInfos(
            HttpServletRequest request) {
        return "page/news/foodList";
    }

    @RequestMapping("/userlists")
    public String users(
            HttpServletRequest request) {

        return "page/user/allUsers";
    }

}
