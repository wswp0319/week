package com.wp.week.mapper;

import com.wp.week.model.ShapeDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * ShapeMapper数据库操作接口类
 * 
 **/
@Mapper
public interface ShapeMapper<T extends ShapeDto> extends IMapper<T> {

}