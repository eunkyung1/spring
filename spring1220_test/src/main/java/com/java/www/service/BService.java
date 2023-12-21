package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//게시글 전체가져오기
	ArrayList<BoardDto> selectAll();

	Map<String , Object> selectOne(int bno);

	void bInsert(BoardDto bdto);

	void doBUpdate(BoardDto bdto);

	void bDelete(int bno);

	void doBReply(BoardDto bdto);

}
