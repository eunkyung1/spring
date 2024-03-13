package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.YmemberDto;

@Mapper
public interface BoardMapper {

	YmemberDto loginCheck(String id, String pw);


}//BoardMapper
