package com.java.www.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.www.dto.UsedDto;

public interface UsedService {
	//trade1 받기 - 중고거래
	Map<String, Object> selectAll(int page);

	//transfer2 받기 - 중고양도
	Map<String, Object> selectAll2(int page);

	//중고거래 - 거래가능내역 보기
	ArrayList<UsedDto> selectPossible(String u_bstatus);

	//중고양도 - 거래가능내역 보기
	ArrayList<UsedDto> selectPossible2(String u_bstatus);

	//중고 View 페이지
	UsedDto selectOne(int u_bno);

}
