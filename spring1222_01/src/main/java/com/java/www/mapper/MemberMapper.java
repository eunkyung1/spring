package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인
	 MemberDto loginCheck(String id, String pw);

	 //아이디 체크
	MemberDto idCheck(String id);

	//ajax 로그인체크
	void mInsert(MemberDto mdto);

}
