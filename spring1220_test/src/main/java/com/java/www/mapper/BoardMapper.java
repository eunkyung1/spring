package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll();

	BoardDto selectOne(int bno);

	void bInsert(BoardDto bdto);

	BoardDto selectOneprev(int bno);

	BoardDto selectOnenext(int bno);

	int doBUpdate(BoardDto bdto);

	int bDelete(int bno);

	void bstepUp(BoardDto bdto);

	int doBReply(BoardDto bdto);

	
}
