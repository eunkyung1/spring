package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll();
	
	//게시글 1개
	BoardDto selectOne(int bno);
	//댓글 전체
	ArrayList<BCommentDto> BCommentselectAll(int bno);
	
	//게시글 1개 저장
	void bCommentInsert(BCommentDto cdto);

	//게시글 1개 저장 후 가져오기
	BCommentDto bCommentSelectOne(int cno);

	//게시글 삭제
	int BCommentDelete(int cno);





}
