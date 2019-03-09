package com.wp.week.mapper;

import com.wp.week.model.QualityDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * QualityMapper数据库操作接口类
 * 
 **/
@Mapper
public interface QualityMapper<T extends QualityDto> extends IMapper<T> {

}