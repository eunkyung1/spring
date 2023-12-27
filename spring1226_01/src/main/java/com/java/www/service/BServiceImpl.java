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
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		
		return list;
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
