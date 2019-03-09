package com.wp.week.mapper;

import com.wp.week.model.ReplyDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * ReplyMapper数据库操作接口类
 * 
 **/
@Mapper
public interface ReplyMapper<T extends ReplyDto> extends IMapper<T> {

}