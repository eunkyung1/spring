package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> blist();

	//게시글 저장
	void write(BoardDto bdto);

	BoardDto selectOne(int bno);

}
