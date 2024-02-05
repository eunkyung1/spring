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
	public Map<String, Object> selectAll(int page) {
		
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectCountAll();
		System.out.println("UsedServiceImpl selectAll countAll"+countAll);
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		List<UsedDto> list = usedMapper.selectAll(startRow,endRow);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}

	//u_btype='transfer2'
	@Override
	public Map<String, Object> selectAll2(int page) {
		if(page<=0) page =1;
		int countPerPage = 8;
		int bottomPerNum = 10;
		int countAll = usedMapper.selectCountAll2();
		System.out.println("UsedServiceImpl selectAll countAll"+countAll);
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow + countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		
		
		List<UsedDto> list2 = usedMapper.selectAll2(startRow,endRow);
		Map<String, Object> map = new HashMap<>();
		map.put("list2", list2);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}

	//u_status = '1'(trade1)
	@Override
	public ArrayList<UsedDto> selectPossible(String u_bstatus) {
		ArrayList<UsedDto> list = usedMapper.selectPossible(u_bstatus);
		return list;
	}
	
	//u_status = '1'(transfer2)
	@Override
	public ArrayList<UsedDto> selectPossible2(String u_bstatus) {
		ArrayList<UsedDto> list2 = usedMapper.selectPossible2(u_bstatus);
		return list2;
	}

	//View탭
	@Override
	public UsedDto selectOne(int u_bno) {
		UsedDto udto = usedMapper.selectOne(u_bno);
		return udto;
	}

}
