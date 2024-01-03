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

	@Override
	public String idCheck(String id) {
		int result = 0;
		
		MemberDto memberDto = memberMapper.idCheck(id);
		if(memberDto==null) {
			result= 1;
			
		}
		return result+"";
	}
	
	//이름과 이메일로 아이디 찾기
	@Override
	public String memberSearch(String name, String email) {
		System.out.println("MServiceImpl memberSearch name : "+name);
		System.out.println("MServiceImpl memberSearch email : "+email);
		
		String result = "불일치";
		MemberDto memberDto = memberMapper.memberSearch(name,email);
		
		
		if(memberDto != null) {
			result = "인증완료";
			session.setAttribute("memberID", memberDto.getId());
			System.out.println("memberID : "+memberDto.getId());
			System.out.println("result :"+result);
		}
		return result;
	}



}
