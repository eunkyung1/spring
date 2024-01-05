package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BService {

	List<BoardDto> selectAll();

	void bwrite(BoardDto bdto);

	BoardDto selectOne(int bno);

}
