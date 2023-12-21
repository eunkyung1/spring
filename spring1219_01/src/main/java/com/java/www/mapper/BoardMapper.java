package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll(int startRow, int endRow);

	//게시글 총개수
	int selectCountAll();

	//게시글 1개 현재글 가져오기 
	BoardDto selectOne(int bno);

	//게시글 1개 이전글 가져오기
	BoardDto selectOnePrev(int bno);

	//게시글 1개 다음글 가져오기
	BoardDto selectOneNext(int bno);

	//조회수 1증가
	void bhitUp(int bno);
	
	//글쓰기 저장
	int bInsert(BoardDto bdto);

	//게시글 삭제
	int bDelete(int bno);
	
	//게시글 수정저장
	int doBUpdate(BoardDto bdto);

	
	
	//답변달기 저장
	void bstepUp(BoardDto bdto);//다른게시글 bstep 1증가 
	int doBReply(BoardDto bdto);



	
	//글쓰기 저장
	
}
