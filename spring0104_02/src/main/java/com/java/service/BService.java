package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BService {

	//게시글 전체
	List<BoardDto> selectAll();

	//게시글 저장
	void bwrite(BoardDto bdto);

	BoardDto selectOne(int bno);




}
