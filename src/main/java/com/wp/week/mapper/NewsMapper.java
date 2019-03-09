package com.wp.week.mapper;

import com.wp.week.model.NewsDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * NewsMapper数据库操作接口类
 * 
 **/
@Mapper
public interface NewsMapper<T extends NewsDto> extends IMapper<T> {

}