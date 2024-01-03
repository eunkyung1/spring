package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;
import com.java.www.dto.MemberDto2;

@Mapper
public interface MemberMapper {

	MemberDto2 login(MemberDto2 mdto2);

	MemberDto2 idCheck(String id);

	MemberDto2 memberSearch(String name, String email);

	MemberDto2 pwsearch(String id, String email);

	//패스워드 변경
	void update_pw(String id, String pwcode);
	

}
