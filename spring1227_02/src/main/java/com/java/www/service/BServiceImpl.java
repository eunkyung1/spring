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

import jakarta.servlet.http.HttpSession;

@Service
public class BServiceImpl implements BService {
	
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	HttpSession session;

	//-------------게시글 전체
	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		
		return list;
	}

	//게시글 1개 가져오기, 댓글 가져오기
	@Override
	public Map<String, Object> selectOne(int bno) {
		
		BoardDto bdto = boardMapper.selectOne(bno);
		ArrayList<BCommentDto> list = boardMapper.BCommentselectAll(bno);
		
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("bdto", bdto);
		map.put("list", list);
		
		
		return map;
	}

	//댓글 1개 저장 후 불러오기.
	@Override
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		cdto.setId((String)session.getAttribute("session_id"));
		boardMapper.bCommentInsert(cdto);
		BCommentDto bCommentDto = boardMapper.bCommentSelectOne(cdto.getCno());
		
		return bCommentDto;
	}
	//댓글 1개 삭제하기
	@Override
	public String BCommentDelete(int cno) {
		String result = ""; 
		int re = boardMapper.BCommentDelete(cno);
		
		return result+re;
	}


}
