package com.wp.week.mapper;

import com.wp.week.model.CargoDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * CargoMapper数据库操作接口类
 * 
 **/
@Mapper
public interface CargoMapper<T extends CargoDto> extends IMapper<T> {

}