package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll();

	BoardDto selectOne(int bno);

	List<BCommentDto> commentSelectAll(int bno);

	//댓글 1개 저장
	void bCommentInsert(BCommentDto cdto);

	//댓글 1개 가져오기
	BCommentDto bCommentSelectOne(int cno);

	//댓글 삭제
	int BCommentDelete(int cno);

	//댓글수정저장
	void BCommentUpdate(BCommentDto cdto);




}
