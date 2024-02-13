package com.java.www.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.www.dto.UsedDto;

public interface UsedService {
	//trade1 받기 - 중고거래
	Map<String, Object> selectAll(int page, String category, String searchWord);

	//transfer2 받기 - 중고양도
	Map<String, Object> selectAll2(int page, String category, String searchWord);

	//중고거래 - 거래가능내역 보기
	ArrayList<UsedDto> selectPossible(int u_bstatus, String u_btype);

	//중고양도 - 거래가능내역 보기
	ArrayList<UsedDto> selectPossible2(String u_bstatus);

	//중고 View 페이지
	Map<String, Object> selectOne(int u_bno, String u_btype);

	//글쓰기 저장
	void usedWrite(UsedDto udto);

	//중고거래 거래가능 하단넘버링
	Map<String, Object> selectP_num(int u_bstatus, int page, String u_btype, String category, String searchWord);

	//글쓰기 삭제
	void usedDelete(int u_bno);

	//거래완료버튼 
	int usedComplete(int u_bno);


	//중고거래 하단넘버링 합치기
	//Map<String, Object> selectAllt(int page, int u_bstatus, String u_btype);
	
	

}
