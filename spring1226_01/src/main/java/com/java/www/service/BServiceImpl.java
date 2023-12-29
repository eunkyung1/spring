package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper boardMapper;

	//-------------게시글 전체
	@Override
	public Map<String, Object> selectAll(int page) {
		if(page<=0) page=1;
		int countPerPage = 10; //1페이지당 게시글 수
		int bottomPerNum = 10;
		int countAll = boardMapper.selectCountAll();
		
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1;
		int endPage = (startPage+bottomPerNum)-1;
		
		int startRow = (page-1)*countPerPage+1;
		int endRow = startRow+ countPerPage-1;
		
		if(endPage>maxPage) endPage = maxPage;
		ArrayList<BoardDto> list = boardMapper.selectAll(startRow,endRow);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list",list);
		map.put("countAll",countAll);
		map.put("page",page);
		map.put("maxPage",maxPage);
		map.put("startPage",startPage);
		map.put("endPage",endPage);
		
		
		return map;
	}

	//-----------게시글 1개
	@Override
	public Map<String, Object> selectOne(int bno) {
		System.out.println("BServiceImpl selectOne bno : "+bno);
		//map - 게시글 , 댓글 전체 가져오기
		BoardDto bdto = boardMapper.selectOne(bno);
		
		ArrayList<BCommentDto> list =boardMapper.BCommentSelectAll(bno);
		System.out.println("selectOne list : "+list.size());
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("list", list);
		
		
		return map;
	}
	
	@Override
	public BCommentDto bCommentInsert(BCommentDto cdto) {
		//댓글 1개 저장
		boardMapper.bCommentInsert(cdto);//Insert
		System.out.println("BServiceImpl bCommentInsert getCno : "+cdto.getCno());
		
		//저장된 댓글 1개 가져오기
		BCommentDto bCommentDto = boardMapper.BCommentSelectOne(cdto.getCno());
		System.out.println("BServiceImpl BCommentSelectOne getCcontent : "+bCommentDto.getCcontent());
		
		return bCommentDto;
	}
	
	

}
