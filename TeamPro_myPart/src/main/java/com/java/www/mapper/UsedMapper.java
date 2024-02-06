package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.UsedDto;

@Mapper
public interface UsedMapper {

	//중고거래
	List<UsedDto> selectAll(int startRow, int endRow);
	//중고양도
	List<UsedDto> selectAll2(int startRow, int endRow);
	
	//u_status = '1'(trade1)
	ArrayList<UsedDto> selectPossible(String u_bstatus);

	//u_status = '1'(transfer2)
	ArrayList<UsedDto> selectPossible2(String u_bstatus);
	
	//게시글 갯수 가져오기(trade1)
	int selectCountAll();
	
	//게시글 갯수 가져오기(transfer2)
	int selectCountAll2();
	
	//View탭
	UsedDto selectOne(int u_bno);
	
	//글쓰기
	void usedWrite(UsedDto udto);

}
