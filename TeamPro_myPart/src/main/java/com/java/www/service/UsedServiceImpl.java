package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.UsedDto;
import com.java.www.mapper.UsedMapper;

@Service
public class UsedServiceImpl implements UsedService {
	
	@Autowired UsedMapper usedMapper;

	//u_btype='trade1'
	@Override
	public Map<String, Object> selectAll(int page, String category, String searchWord, int u_bstatus, String u_btype) {
		
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectCountAll(category,searchWord,u_bstatus,u_btype);
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		List<UsedDto> list = usedMapper.selectAll(startRow,endRow,category,searchWord,u_bstatus,u_btype);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("u_bstatus", u_bstatus);
		map.put("u_btype", u_btype);
		map.put("category", category);
		map.put("searchWord", searchWord);
		return map;
	}

	
	//중고거래 거래가능 하단넘버링
	@Override
	public Map<String, Object> selectP_num(int u_bstatus, int page, String u_btype,String category, String searchWord) {
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectP_count(u_bstatus,u_btype,category,searchWord);

		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		List<UsedDto> list = usedMapper.used_PerNum(u_bstatus,u_btype,startRow,endRow,category,searchWord);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("category", category);
		map.put("searchWord", searchWord);
		
		return map;
		
	}



	//View탭 & 이전글,다음글 가져오기
	@Override
	public Map<String, Object> selectOne(int u_bno,String u_btype) {
		UsedDto udto = usedMapper.selectOne(u_bno,u_btype);
		UsedDto preudto = usedMapper.selectOneprev(u_bno,u_btype);
		UsedDto nextudto = usedMapper.selectOnenext(u_bno,u_btype);
		
		Map<String, Object> map = new HashMap<>();
		map.put("udto", udto);
		map.put("preudto", preudto);
		map.put("nextudto", nextudto);
		map.put("u_btype",u_btype);
		return map;
	}
	//usedWrite 글쓰기
	@Override
	public void usedWrite(UsedDto udto) {
		usedMapper.usedWrite(udto);
	}
	//글 삭제
	@Override
	public void usedDelete(int u_bno) {
		usedMapper.usedDelete(u_bno);
		
	}
	//거래완료 버튼
	@Override
	public int usedComplete(int u_bno) {
		int result = usedMapper.usedComplete(u_bno);
		return result;
	}
	//글 수정 저장하기
	@Override
	public void usedDoUpdate(UsedDto udto) {
		usedMapper.usedDoUpdate(udto);
		
	}

}
