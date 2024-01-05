package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectAll();

	void bwrite(BoardDto bdto);

	BoardDto selectOne(int bno);

}
