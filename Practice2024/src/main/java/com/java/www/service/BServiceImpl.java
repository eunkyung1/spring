package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.YmemberDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {
	
	@Autowired BoardMapper boardMapper;

	@Override
	public YmemberDto loginCheck(String id, String pw) {
		
		YmemberDto ymemberdto = boardMapper.loginCheck(id,pw);
		
		
		return ymemberdto;
	}



}//BServiceImpl
