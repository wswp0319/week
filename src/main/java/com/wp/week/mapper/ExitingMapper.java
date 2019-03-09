package com.wp.week.mapper;

import com.wp.week.model.ExitingDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * ExitingMapper数据库操作接口类
 * 
 **/
@Mapper
public interface ExitingMapper<T extends ExitingDto> extends IMapper<T> {

}