package com.wp.week.mapper;

import com.wp.week.model.QuantityDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * QuantityMapper数据库操作接口类
 * 
 **/
@Mapper
public interface QuantityMapper<T extends QuantityDto> extends IMapper<T> {

}