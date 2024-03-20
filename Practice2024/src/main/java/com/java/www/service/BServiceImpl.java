package com.java.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.YmemberDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;

	
	//로그인하기
	@Override
	public YmemberDto loginCheck(String id, String pw) {
		
		YmemberDto ymemberdto = boardMapper.loginCheck(id,pw);
		
		
		return ymemberdto;
	}

	//리스트 전체 불러오기
	@Override
	public List<YmemberDto> selectAll() {
		List<YmemberDto> list = boardMapper.selectAll();
		
		return list;
	}



}//BServiceImpl
