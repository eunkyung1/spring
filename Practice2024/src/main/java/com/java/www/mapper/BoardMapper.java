package com.java.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.YmemberDto;

@Mapper
public interface BoardMapper {

	//로그인
	YmemberDto loginCheck(String id, String pw);

	//리스트 가져오기
	List<YmemberDto> selectAll();


}//BoardMapper
