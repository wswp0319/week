package com.wp.week.controller;

import com.wp.week.mapper.IningMapper;
import com.wp.week.model.ExitingDto;
import com.wp.week.model.IningDto;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IningController {

    @Autowired
    private IningMapper<IningDto> iningMapper;

    /**
     * @param request
     * @return
     */
    @RequestMapping("/getInings")
    @ResponseBody
    public AjaxList getQuantitys(
            HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        List<IningDto> list = iningMapper.list(new HashMap());

//        AjaxList ajaxList = quantityService.getList(map);

        return AjaxList.createSuccess("",list);
    }




    @RequestMapping("/inings")
    public String plantInfos(
            HttpServletRequest request) {
        return "page/news/iningList";
    }
}
