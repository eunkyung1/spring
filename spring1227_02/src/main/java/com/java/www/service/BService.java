package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {
	//공지사항 전첸
	ArrayList<BoardDto> selectAll();

	Map<String, Object> selectOne(int bno);
	
	
	//댓글 1개 저장하기
	BCommentDto BCommentInsert(BCommentDto cdto);

	String BCommentDelete(int cno);



	



}
