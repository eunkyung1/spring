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
		int result = 0;
		mdto = memberMapper.login(mdto);
		
		if(mdto!=null) {
		result=1;
		session.setAttribute("session_id", mdto.getId());
		session.setAttribute("session_nicName", mdto.getName());
		System.out.println("MServiceImpl login result : "+result);
		System.out.println("MServiceImpl session_id "+mdto.getId());
		}
		
		return result;
	}

}
