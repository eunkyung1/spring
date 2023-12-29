package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {
	
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	HttpSession session;
	
	@Override
	public int login(MemberDto mdto) {
		int result =0;
		//mapper 연결 
		MemberDto memDto = memberMapper.login(mdto);
		if(memDto!= null) {
			session.setAttribute("session_id", memDto.getId());
			session.setAttribute("session_name", memDto.getName());
			result=1;
			
		}
		
		return result;
	}

}
