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
import java.util.Map;

@Controller
public class QuantityController {

    @Autowired
    private quantityService quantityService;

    /**
     * @param request
     * @return
     */
    @RequestMapping("/getQuantitys")
    @ResponseBody
    public AjaxList getQuantitys(
            HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();


        AjaxList ajaxList = quantityService.getList(map);

        return ajaxList;
    }


    @RequestMapping("/delOneQuantity")
    @ResponseBody
    public AjaxList delOneQuantity(
            @ApiParam(name = "quantityId", value = "id", required = true) @RequestParam Integer quantityId,
            HttpServletRequest request) {

//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");

        AjaxList ajaxList = quantityService.delOne(quantityId);

        return ajaxList;
    }

    //页面跳转
    @RequestMapping("/editQuantity")
    public String editquantity(
            @ApiParam(name = "quantityId", value = "id") @RequestParam(required = false) Integer quantityId,
            Model model) {

        QuantityDto quantityDto = new QuantityDto();
        quantityDto.setId(quantityId);

        if (quantityId != null) {
            quantityDto = quantityService.getById(quantityId);
        }

        model.addAttribute("quantityDto", quantityDto);

        return "page/news/quantityAdd";
    }


    //    private Integer id;
//    /**粮食编号**/
//    private Integer plantNo;
//    /**植物名称**/
//    private String plantName;
//    /**类别所属**/
//    private Integer gsno;
//    /**产地分布**/
//    private String prodarea;
//    /**生态习性**/
//    private String ecolhabit;
//    /****/
//    private String imagePath;
//    /**二维码**/
//    private String dimenCode;
//    private java.util.Date createTime;
//    private java.util.Date updateTime;
//    /**是否发布**/
//    private String isState;
//    /****/
//    private String remark;
    @Autowired
    private ExitingMapper<ExitingDto> exitingMapper;

    @Autowired
    private IningMapper<IningDto> iningMapper;


    @RequestMapping("/addOrUpdateQuantity")
    public String addOrUpdatequantity(
            @ApiParam(name = "plantId", value = "id") @RequestParam(required = false) Integer plantId,

            @ApiParam(name = "inQuantity", value = "ru", required = true) @RequestParam Integer inQuantity,
            @ApiParam(name = "outQuantity", value = "chu", required = true) @RequestParam Integer outQuantity,

            @ApiParam(name = "remark", value = "beizhu") @RequestParam(required = false) String remark,
            HttpServletRequest request,
            Model model) {


        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        QuantityDto quantityDto = new QuantityDto();
        Map<String, Object> map = new HashMap<>();
        map.put("plantId",plantId);

        AjaxList one = quantityService.findOne(map);
        if (!one.isSuccess()) {
            return null;
        }

        QuantityDto tyDto = (QuantityDto) one.getData();
        tyDto.setId(plantId);
        tyDto.setInQuantity(tyDto.getInQuantity() + inQuantity);
        tyDto.setOutQuantity(tyDto.getOutQuantity()+outQuantity);
        tyDto.setTotalQuantity(tyDto.getTotalQuantity()+inQuantity-outQuantity);


        //出库
        ExitingDto exitingDto = new ExitingDto();
        exitingDto.setGrainNumber(plantId.toString());
        exitingDto.setOutNum(outQuantity);
        exitingDto.setOutTime(new Date());
        exitingDto.setRemark("出库");
        exitingDto.setIsactive("是");
        exitingMapper.add(exitingDto);

        //入库
        IningDto iningDto = new IningDto();
        iningDto.setGrainNumber(plantId.toString());
        iningDto.setInNumber(inQuantity);
        iningDto.setStorageTime(new Date());
        iningDto.setRemark("入库");
        iningMapper.add(iningDto);

        tyDto.setPlantId(plantId.toString());
        quantityService.addOrUpdate(tyDto);

        return "page/news/quantityList";
    }


    @RequestMapping("/quantitys")
    public String plantInfos(
            HttpServletRequest request) {
        return "page/news/quantityList";
    }
}
