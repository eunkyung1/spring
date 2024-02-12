package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.UsedDto;

@Mapper
public interface UsedMapper {

	//중고거래
	List<UsedDto> selectAll(int startRow, int endRow, String category, String searchWord);
	//중고양도
	List<UsedDto> selectAll2(int startRow, int endRow, String category, String searchWord);
	
	//u_status = '1'(trade1)
	ArrayList<UsedDto> selectPossible(int u_bstatus,String u_btype);

	//u_status = '1'(transfer2)
	ArrayList<UsedDto> selectPossible2(String u_bstatus);
	
	//게시글 갯수 가져오기(trade1)
	int selectCountAll(String category, String searchWord);
	
	//게시글 갯수 가져오기(transfer2)
	int selectCountAll2(String category, String searchWord);
	
	//View탭
	UsedDto selectOne(int u_bno, String u_btype);
	
	//글쓰기
	void usedWrite(UsedDto udto);
	
	//중고거래 거래가능 하단넘버링(총 게시글 수)
	int selectP_count(int u_bstatus, String u_btype);
	
	//중고거래 거래가능 하단넘버링
	List<UsedDto> used_PerNum(int u_bstatus, String u_btype, int startRow, int endRow);
	
	//중고거래 리스트 & 하단넘버링 테스
	List<UsedDto> selectAllt(int u_bstatus, String u_btype, int startRow, int endRow);
	
	//중고거래 이전글 가져오기
	UsedDto selectOneprev(int u_bno, String u_btype);
	
	//중고거래 다음글 가져오기
	UsedDto selectOnenext(int u_bno, String u_btype);
	

}
