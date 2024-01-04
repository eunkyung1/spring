package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	@Autowired BoardMapper boardMapper;

	//게시글 전체 끌어오기
	@Override
	public List<BoardDto> selectAll() {
		List<BoardDto> list = boardMapper.selectAll();
		return list;
	}
	
	//게시글 저장하기
	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.bwrite(bdto);
		
	}
	//1개의 게시글 불러오기
	@Override
	public BoardDto selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		return bdto;
	}

	
	
}
