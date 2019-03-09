package com.wp.week.service;

import com.wp.week.mapper.IMapper;
import com.wp.week.mapper.QuantityMapper;
import com.wp.week.model.QuantityDto;
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
public class quantityService extends BaseServiceImpl<QuantityDto> {

    @Autowired
    private QuantityMapper<QuantityDto> quantityMapper;

    @Autowired
    private UserService userService;

    public AjaxList getList(Map<String, Object> map) {

        List<QuantityDto> dailys = quantityMapper.list(map);

        return AjaxList.createSuccess("获取成功", dailys);
    }


    public AjaxList delOne(Integer quantityId) {

        QuantityDto quantityDto = new QuantityDto();
        quantityDto.setId(quantityId);

        return this.delete(quantityDto);
    }

    /**
     * 新增或修改周报
     *
     * @param quantityDto
     */
    public void addOrUpdate(QuantityDto quantityDto) {

        Integer id = quantityDto.getId();
        Date date = new Date();
        if (id == null) {
            quantityDto.setCreateTime(date.toString());
            quantityDto.setUpdateTime(date.toString());
            this.add(quantityDto);
        } else {
//            quantityDto.setUpdateTime(date.toString());
            this.edit(quantityDto);
        }
    }

    public QuantityDto getById(Integer quantityId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", quantityId);

        return quantityMapper.selInfo(map);
    }


    @Override
    public IMapper<QuantityDto> getMapper() {
        return quantityMapper;
    }
}
