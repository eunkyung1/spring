package com.java.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.YmemberDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;

	
	//로그인하기
	@Override
	public YmemberDto loginCheck(String id, String pw) {
		
		YmemberDto ymemberdto = boardMapper.loginCheck(id,pw);
		
		
		return ymemberdto;
	}

	//리스트 전체 불러오기
	@Override
	public Map<String, Object> selectAll(int searchCount,int page) {
		if(page<=0) page =1;
		int countPerPage = searchCount;
		int bottomPerNum = 10;
		System.out.println(searchCount);
		int countAll = boardMapper.selectCountAll();
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage -1;
		if(endPage>maxPage) endPage=maxPage;
		
		List<YmemberDto> list = boardMapper.selectAll(startRow, endRow);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage",startPage);
		map.put("endPage", endPage);
		
		return map;
	}



}//BServiceImpl
