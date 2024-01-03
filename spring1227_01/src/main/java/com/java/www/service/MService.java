package com.java.www.service;

import com.java.www.dto.MemberDto;

public interface MService {

	int login(MemberDto mdto);

	String idCheck(String id);

	//이름과 이메일로 회원찾기
	String memberSearch(String name, String email);

}
