package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> selectAll(int startRow, int endRow);

	//게시글 전체 개수 가져오기
	int selectCountAll();

	BoardDto selectOne(int bno);

	//댓글가져오기
	ArrayList<BCommentDto> BCommentSelectAll(int bno);
	
	
	//db에 저장된 댓글 1개 가져오기 - cno, cdate가 포함되어 있음.
	void bCommentInsert(BCommentDto cdto);

	//저장된 댓글 1개 가져오기
	BCommentDto BCommentSelectOne(int cno);
	



}
