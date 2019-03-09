package com.wp.week.mapper;

import com.wp.week.model.SysLogDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * SysLogMapper数据库操作接口类
 * 
 **/
@Mapper
public interface SysLogMapper<T extends SysLogDto> extends IMapper<T> {

}