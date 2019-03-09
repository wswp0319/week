package com.wp.week.service;

import com.wp.week.mapper.IMapper;
import com.wp.week.mapper.PlantInfoMapper;
import com.wp.week.model.PlantInfoDto;
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
public class PlantInfoService extends BaseServiceImpl<PlantInfoDto> {

    @Autowired
    private PlantInfoMapper<PlantInfoDto> plantInfoMapper;

    @Autowired
    private UserService userService;

    public AjaxList getList(Map<String, Object> map) {

        List<PlantInfoDto> dailys = plantInfoMapper.list(map);

        return AjaxList.createSuccess("获取成功", dailys);
    }


    public AjaxList delOne(Integer plantInfoId) {

        PlantInfoDto plantInfoDto = new PlantInfoDto();
        plantInfoDto.setId(plantInfoId);

        return this.delete(plantInfoDto);
    }

    /**
     * 新增或修改周报
     *
     * @param PlantInfoDto
     */
    public void addOrUpdate(PlantInfoDto PlantInfoDto) {

        Integer id = PlantInfoDto.getId();
        Date date = new Date();
        if (id == null) {
            PlantInfoDto.setCreateTime(date.toString());
            PlantInfoDto.setUpdateTime(date.toString());
            this.add(PlantInfoDto);
        } else {
            PlantInfoDto.setUpdateTime(date.toString());
            this.edit(PlantInfoDto);
        }
    }

    public PlantInfoDto getById(Integer plantInfoId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", plantInfoId);

        return plantInfoMapper.selInfo(map);
    }


    @Override
    public IMapper<PlantInfoDto> getMapper() {
        return plantInfoMapper;
    }
}
