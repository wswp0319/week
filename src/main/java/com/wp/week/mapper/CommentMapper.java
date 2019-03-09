package com.wp.week.mapper;

import com.wp.week.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * CommentMapper数据库操作接口类
 * 
 **/
@Mapper
public interface CommentMapper<T extends CommentDto> extends IMapper<T> {

}