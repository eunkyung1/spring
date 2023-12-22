package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MserviceImpl implements MService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	HttpSession session;
	
	//로그인
	@Override
	public int loginCheck(String id, String pw) {
		
		int result=0;
		MemberDto mdto = memberMapper.loginCheck(id,pw);
		if(mdto!=null) {
			result = 1;
			session.setAttribute("sesson_id", mdto.getId());
			session.setAttribute("session_nicName", mdto.getName());
			System.out.println("MserviceImpl loginCheck  sesson_id : "+mdto.getId());
			System.out.println("MserviceImpl loginCheck  session_nicNmae : "+mdto.getName());
		}
		System.out.println("MserviceImpl loginCheck  sesson_id : "+mdto.getId());
		System.out.println("MserviceImpl loginCheck  session_nicNmae : "+mdto.getName());
		return result;
	}
	//아이디체크
	@Override
	public String idCheck(String id) {
		String result = "사용불가";
		//db접근
		MemberDto mdto = memberMapper.idCheck(id);
		if(mdto==null) result="사용가능";
		return result;
	}
	
	//ajax 회원가입
	@Override
	public String mInsert(MemberDto mdto) {
		String result="가입완료";
		memberMapper.mInsert(mdto);
		
		if(mdto!=null)result="가입완료";
		return result;
	} 

}
