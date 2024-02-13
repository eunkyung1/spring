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
	public Map<String, Object> selectAll(int page, String category, String searchWord) {
		
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectCountAll(category,searchWord);
		
		
		System.out.println("UsedServiceImpl selectAll countAll"+countAll);
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		List<UsedDto> list = usedMapper.selectAll(startRow,endRow,category,searchWord);
		
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
	/*
	//리스트띄우기 & 하단넘버링 
	@Override
	public Map<String, Object> selectAllt(int page, int u_bstatus, String u_btype) {
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		//int countAll = usedMapper.selectCountAll();
		int countAllt = usedMapper.selectP_count(u_bstatus, u_btype);
		System.out.println("UsedServiceImpl selectAll countAll"+countAllt);
		
		int maxPage = (int)Math.ceil((double)countAllt/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		
		if(u_bstatus == 0) {
		List<UsedDto> list = usedMapper.selectAllt(u_bstatus,u_btype,startRow,endRow);
		}else{
		List<UsedDto> list = usedMapper.selectAll(startRow,endRow);
				
			}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAllt);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
*/
	
	//u_btype='transfer2'
	@Override
	public Map<String, Object> selectAll2(int page, String category, String searchWord) {
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectCountAll2(category,searchWord);
		System.out.println("UsedServiceImpl selectAll countAll"+countAll);
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		
		
		List<UsedDto> list2 = usedMapper.selectAll2(startRow,endRow,category,searchWord);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("list2", list2);
		map2.put("countAll", countAll);
		map2.put("page", page);
		map2.put("maxPage", maxPage);
		map2.put("startPage", startPage);
		map2.put("endPage", endPage);
		map2.put("category", category);
		map2.put("searchWord", searchWord);
		return map2;
	}

	//u_status = '1'(trade1)
	@Override
	public ArrayList<UsedDto> selectPossible(int u_bstatus,String u_btype) {
		ArrayList<UsedDto> list = usedMapper.selectPossible(u_bstatus,u_btype);
		return list;
	}
	
	//u_status = '1'(transfer2)
	@Override
	public ArrayList<UsedDto> selectPossible2(String u_bstatus) {
		ArrayList<UsedDto> list2 = usedMapper.selectPossible2(u_bstatus);
		return list2;
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
	
	//중고거래 거래가능 하단넘버링
	@Override
	public Map<String, Object> selectP_num(int u_bstatus, int page, String u_btype,String category, String searchWord) {
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectP_count(u_bstatus,u_btype,category,searchWord);
		System.out.println("UsedServiceImpl selectP_num selectP_count "+countAll);
		
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
	//전체페이지 test
	/*
	@Override
	public Map<String, Object> selectAll_t(int page, String category, String searchWord, int u_bstatus, String u_btype) {
		// TODO Auto-generated method stub
		return null;
	}
*/

}
