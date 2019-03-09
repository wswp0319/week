package com.wp.week.service;

import com.wp.week.mapper.DailyMapper;
import com.wp.week.mapper.UserMapper;
import com.wp.week.model.DailyDto;
import com.wp.week.model.UserDto;
import com.wp.week.utils.AjaxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class DailyService {

    @Autowired
    private DailyMapper dailyMapper;

    @Autowired
    private UserService userService;

    public AjaxList getDailysByRole(Map<String, Object> map) {

        List<DailyDto> dailys = dailyMapper.getDailysByRole(map);

        return AjaxList.createSuccess("获取成功", dailys);
    }

    public AjaxList delOneDaily(Integer dailyId, String username) {


        DailyDto dailyDto = dailyMapper.selectByPrimaryKey(dailyId);
        UserDto userDto = userService.geUserByName(username);

        //非管理员
        if (userDto.getRule() != 1) {
            if (!dailyDto.getSubmitter().trim().equals(username)) {
                return AjaxList.createError("非管理员不能操作他人记录");
            }
        }
        //不处理异常情况
        dailyMapper.deleteByPrimaryKey(dailyId);
        return AjaxList.createSuccess("删除成功");
    }

    /**
     * 新增或修改周报
     *
     * @param dailyDto
     */
    public void addOrUpdateDaily(DailyDto dailyDto) {

        Integer id = dailyDto.getId();
        Date date = new Date();
        if (id == null) {
            dailyDto.setCreateTime(date);
            dailyDto.setUpdateTime(date);
            dailyMapper.insert(dailyDto);
        } else {
            dailyDto.setUpdateTime(date);
            dailyMapper.updateByPrimaryKey(dailyDto);
        }
    }

    public DailyDto getDailysById(Integer dailyId) {
        return dailyMapper.selectByPrimaryKey(dailyId);
    }

    public AjaxList updateClaim(Integer dailyId, Integer claim) {

        DailyDto dailyDto = new DailyDto();
        dailyDto.setId(dailyId);
        dailyDto.setClaim(claim);
        dailyMapper.updateByPrimaryKeySelective(dailyDto);

        return AjaxList.createSuccess("修改成功！");
    }

    public List<Map<String, Object>> getDailysExcel(Map<String, Object> map) {
        return dailyMapper.getDailysExcel(map);
    }

    public AjaxList canEdit(Integer dailyId, String username) {

        DailyDto dailyDto = dailyMapper.selectByPrimaryKey(dailyId);
        UserDto userDto = userService.geUserByName(username);

        //非管理员
        if (userDto.getRule() != 1) {
            if (!dailyDto.getSubmitter().trim().equals(username)) {
                return AjaxList.createError("非管理员不能操作他人记录");
            }
        }
        //不处理异常情况
        return AjaxList.createSuccess("可以编辑此记录");
    }
}
