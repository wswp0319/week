package com.wp.week.mapper;

import com.wp.week.model.DynamicInfoDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * DynamicInfoMapper数据库操作接口类
 * 
 **/
@Mapper
public interface DynamicInfoMapper<T extends DynamicInfoDto> extends IMapper<T> {

}