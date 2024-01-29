package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.NBoardDto;
import com.java.www.mapper.NBoardMapper;


@Service
public class NBoardServiceImpl implements NBoardService{
	
	@Autowired NBoardMapper nbMapper;
	
	//게시글 전체가져오기
	@Override
	public Map<String, Object> selectAll(int page) {
		
		
		if(page<=0) page=1;
		int countPerPage = 10;
		int bottomPerNum = 10;
		int countAll = nbMapper.selectCountAll();
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		ArrayList<NBoardDto> list = nbMapper.selectAll(startRow, endRow);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		
		return map;
	}

	//게시글 1개 가져오기
	@Override
	public NBoardDto selectOne(int n_bno) {
		NBoardDto nboardDto = nbMapper.selectOne(n_bno);
		
		
		return nboardDto;
	}

	//게시글 글쓰기
	@Override
	public void bWrite(NBoardDto nbdto) {
		nbMapper.bWrite(nbdto);
		
	}

}
