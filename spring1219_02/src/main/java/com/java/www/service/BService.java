package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {
	
	//게시글 전체
	ArrayList<BoardDto> selectAll();

	//게시글 1개
	Map<String, Object> selectOne(int bno);
	
	//게시글 저장

	void bInsert(BoardDto bdto);


}
