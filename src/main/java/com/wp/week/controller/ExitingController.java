package com.wp.week.controller;

import com.wordnik.swagger.annotations.ApiParam;
import com.wp.week.mapper.ExitingMapper;
import com.wp.week.mapper.IningMapper;
import com.wp.week.model.ExitingDto;
import com.wp.week.model.IningDto;
import com.wp.week.model.QuantityDto;
import com.wp.week.service.quantityService;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExitingController {

    @Autowired
    private ExitingMapper<ExitingDto> exitingMapper;

    /**
     * @param request
     * @return
     */
    @RequestMapping("/getExitings")
    @ResponseBody
    public AjaxList getQuantitys(
            HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        List<ExitingDto> list = exitingMapper.list(new HashMap());

//        AjaxList ajaxList = quantityService.getList(map);

        return AjaxList.createSuccess("",list);
    }




    @RequestMapping("/exitings")
    public String plantInfos(
            HttpServletRequest request) {
        return "page/news/exitingList";
    }
}
