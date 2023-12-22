package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {
	
	//로그인 확인
	int login(String id, String pw);
	
	//idCheck 로그인
	String idCheck(String id);
	
	
	//회원가입 저장
	String mInsert(MemberDto mdto);

}
