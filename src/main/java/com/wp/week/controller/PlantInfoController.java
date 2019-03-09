package com.wp.week.controller;

import com.wordnik.swagger.annotations.ApiParam;
import com.wp.week.model.PlantInfoDto;
import com.wp.week.service.PlantInfoService;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PlantInfoController {

    @Autowired
    private PlantInfoService plantInfoService;

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/getPlantInfos")
    @ResponseBody
    public AjaxList getPlantInfos(
            HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();


        AjaxList ajaxList = plantInfoService.getList(map);

        return ajaxList;
    }


    @RequestMapping("/delOneplantInfo")
    @ResponseBody
    public AjaxList delOneplantInfo(
            @ApiParam(name = "plantInfoId", value = "id", required = true) @RequestParam Integer plantInfoId,
            HttpServletRequest request) {

//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");

        AjaxList ajaxList = plantInfoService.delOne(plantInfoId);

        return ajaxList;
    }

    //页面跳转
    @RequestMapping("/editPlantInfo")
    public String editPlantInfo(
            @ApiParam(name = "plantInfoId", value = "id") @RequestParam(required = false) Integer plantInfoId,
            Model model) {

        PlantInfoDto plantInfoDto = new PlantInfoDto();
        plantInfoDto.setId(plantInfoId);
        if (plantInfoId != null) {
            plantInfoDto = plantInfoService.getById(plantInfoId);
        }

        model.addAttribute("plantInfoDto", plantInfoDto);

        return "page/news/foodAdd";
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

    @RequestMapping("/addOrUpdatePlantInfo")
    public String addOrUpdateplantInfo(
            @ApiParam(name = "plantInfoId", value = "id") @RequestParam(required = false) Integer plantInfoId,
            @ApiParam(name = "plantNo", value = "工作成果", required = true) @RequestParam Integer plantNo,
            @ApiParam(name = "plantName", value = "提交内容", required = true) @RequestParam String plantName,
            @ApiParam(name = "gsno", value = "内容说明", required = true) @RequestParam String gsno,
            @ApiParam(name = "prodarea", value = "开始时间", required = true) @RequestParam String prodarea,
            @ApiParam(name = "ecolhabit", value = "结束时间", required = true) @RequestParam String ecolhabit,
            @ApiParam(name = "imagePath", value = "标准和要求") @RequestParam(required = false) String imagePath,
            @ApiParam(name = "dimenCode", value = "查看权限") @RequestParam(required = false) String dimenCode,
            @ApiParam(name = "isState", value = "补救措施") @RequestParam(required = false) String isState,
            @ApiParam(name = "remark", value = "备注", required = true) @RequestParam(required = false) String remark,
            HttpServletRequest request,
            Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");


        PlantInfoDto plantInfoDto = new PlantInfoDto();
        plantInfoDto.setId(plantInfoId);
        plantInfoDto.setPlantNo(plantNo);
        plantInfoDto.setPlantName(plantName);
        plantInfoDto.setGsno(gsno);
        plantInfoDto.setProdarea(prodarea);
        plantInfoDto.setEcolhabit(ecolhabit);
        plantInfoDto.setImagePath(imagePath);
        plantInfoDto.setDimenCode(dimenCode);
        plantInfoDto.setIsState(isState);
        plantInfoDto.setRemark(remark);

        plantInfoService.addOrUpdate(plantInfoDto);

        return "page/news/foodList";
    }
}
