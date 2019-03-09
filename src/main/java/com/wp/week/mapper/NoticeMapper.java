package com.wp.week.mapper;

import com.wp.week.model.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * NoticeMapper数据库操作接口类
 * 
 **/
@Mapper
public interface NoticeMapper<T extends NoticeDto> extends IMapper<T> {

}