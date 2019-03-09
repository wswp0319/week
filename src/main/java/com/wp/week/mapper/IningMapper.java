package com.wp.week.mapper;

import com.wp.week.model.IningDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * IningMapper数据库操作接口类
 * 
 **/
@Mapper
public interface IningMapper<T extends IningDto> extends IMapper<T> {

}