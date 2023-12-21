package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper boardMapper; 
	
	
	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}//selectAll


	@Override
	public Map<String , Object> selectOne(int bno) {

		BoardDto bdto= boardMapper.selectOne(bno);
		BoardDto bdtoprev = boardMapper.selectOneprev(bno);
		BoardDto bdtonext = boardMapper.selectOnenext(bno);
		
		Map<String , Object> map = new HashMap<>();
		
		map.put("bdto", bdto);
		map.put("bdtoprev", bdtoprev);
		map.put("bdtonext", bdtonext);
		
		return map;
	}//selectOne

	//
	@Override
	public void bInsert(BoardDto bdto) {
		boardMapper.bInsert(bdto);
		
	}

	//게시글 수정하기
	@Override
	public void doBUpdate(BoardDto bdto) {

		int result = boardMapper.doBUpdate(bdto);
		System.out.println("doBUpdate result : "+result);
		
	}


	@Override
	public void bDelete(int bno) {
		int result = boardMapper.bDelete(bno);
		System.out.println("bServiceImpl bDelete result : "+result);
	}


	@Override
	public void doBReply(BoardDto bdto) {
		
		boardMapper.bstepUp(bdto);
		
		int result = boardMapper.doBReply(bdto);
		System.out.println("bServiceImpl doBReply result : "+result);
		
	}



}
