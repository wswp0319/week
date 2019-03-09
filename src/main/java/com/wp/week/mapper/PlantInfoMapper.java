package com.wp.week.mapper;

import com.wp.week.model.PlantInfoDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * PlantInfoMapper数据库操作接口类
 * 
 **/
@Mapper
public interface PlantInfoMapper<T extends PlantInfoDto> extends IMapper<T> {

}