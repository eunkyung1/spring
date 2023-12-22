package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {

	int loginCheck(String id, String pw);
	
	//아이디 체크
	String idCheck(String id);

	//ajax 회원가입
	String mInsert(MemberDto mdto);

}
