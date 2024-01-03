package com.java.www.service;

import com.java.www.dto.MemberDto;
import com.java.www.dto.MemberDto2;

public interface MService {

	int login(MemberDto2 mdto2);

	String idCheck(String id);

	//이름과 이메일로 아이디찾기
	String memberSearch(String name, String email);

	//아이디와 이메일로 비밀번호 찾기
	String pwsearch(String id, String email);

}
