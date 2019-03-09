package com.wp.week.mapper;

import com.wp.week.model.OrderDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * OrderMapper数据库操作接口类
 * 
 **/
@Mapper
public interface OrderMapper<T extends OrderDto> extends IMapper<T> {

}