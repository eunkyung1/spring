package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {

	Map<String, Object> selectAll(int page);

	Map<String, Object> selectOne(int bno);

	//db저장된 1개의 댓글 가져오기
	BCommentDto bCommentInsert(BCommentDto cdto);

}
