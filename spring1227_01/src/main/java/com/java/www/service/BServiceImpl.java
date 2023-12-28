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
	
	//게시글 1개 및 하단댓글 가져오기
	@Override
	public Map<String, Object> selectOne(int bno) {
		
		//게시글 1개 가져오기
		BoardDto bdto = boardMapper.selectOne(bno);
		
		//하단 댓글 모두 가져오기
		List<BCommentDto> commentlist = boardMapper.commentSelectAll(bno);
		
		//Map으로 전송하기
		Map<String, Object> map = new HashMap<>();
		
		map.put("bdto", bdto);
		map.put("commentlist", commentlist);
		
		return map;
	
	}//selectOne

	//댓글 1개 저장 후 가져오기
	@Override
	public BCommentDto bCommentInsert(BCommentDto cdto) {
		//session_id를 cdto에 저장.
		cdto.setId((String)session.getAttribute("session_id"));
		
		//댓글 1개 저장하기
		boardMapper.bCommentInsert(cdto); //댓글폼에서 입력한 내용을 저장시킴
		System.out.println("BServiceImpl bCommentInsert getCno : "+cdto.getCno());
		System.out.println("BServiceImpl bCommentInsert getCdate : "+cdto.getCdate());
		
		//댓글 1개 가져오기
		//BCommentDto bCommentDto = boardMapper.bCommentSelectOne(cdto.getCno()); //댓글폼에서 입력한 내용을 저장시킴
		
		return cdto;
	}

	//댓글 삭제
	@Override
	public String BCommentDelete(int cno) {
		String result = "";
		int re = boardMapper.BCommentDelete(cno);
		
		
		return result+re ;
	}
	
	//댓글수정저장
	@Override
	public BCommentDto BCommentUpdate(BCommentDto cdto) {
		
		cdto.setId((String)session.getAttribute("session_id"));
		
		//수정저장
		boardMapper.BCommentUpdate(cdto);
		//댓글1개 가져오기
		BCommentDto bCommentDto = boardMapper.bCommentSelectOne(cdto.getCno()); //댓글폼에서 입력한 내용을 저장시킴
	
		return bCommentDto;
	}


	
	
	

}
