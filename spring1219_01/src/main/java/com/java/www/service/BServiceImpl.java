package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	//게시글 전체 가져오기
	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}//list selectAll

	//게시글 1개 가져오기 , 이전글, 다음글 가져오기 : 총3개
	@Override
	public Map<String, Object> selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto predto = boardMapper.selectOnePrev(bno);
		BoardDto nextdto = boardMapper.selectOneNext(bno);
		
		//조회수 1증가
		boardMapper.bhitUp(bno);
		
		
		Map<String, Object> map = new HashMap<>(); //map은 인터페이스.
		//List<BoardDto> list = new ArrayList<>(); //이것도 가능
		
		map.put("bdto", bdto);
		map.put("predto", predto);
		map.put("nextdto", nextdto);
		
		return map;
	}//map selectOne

	//글쓰기 저장
	@Override
	public void bInsert(BoardDto bdto) {
		int result = boardMapper.bInsert(bdto);
		System.out.println("bServiceImpl result : "+result);
	}//bInsert

	//게시글 삭제
	@Override
	public void bDelete(int bno) {
		int result = boardMapper.bDelete(bno);
		System.out.println("bServiceImpl bDelete result : "+result);
		
	}

	//게시글 수정 저장
	@Override
	public void doBUpdate(BoardDto bdto) {
		int result = boardMapper.doBUpdate(bdto);
		System.out.println("bServiceImpl doBUpdate result : "+result);
		
	}

	//답변달기 저장
	@Override
	public void doBReply(BoardDto bdto) {
		//답변달기 저장 bgourp, bstep, bindent
		//1. 부모보다 큰 bstep은 1씩 증가시킴
		//2. 현재 글은  부모bstep +1 저장.
		//3. bindent 부모의 1 더하기
		//4. bgroup은 부모와 같음.
		boardMapper.bstepUp(bdto);
		
		int result = boardMapper.doBReply(bdto);
		System.out.println("bServiceImpl doBReply result : "+result);
		
		
	}

}
