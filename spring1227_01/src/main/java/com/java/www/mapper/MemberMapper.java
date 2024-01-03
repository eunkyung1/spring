package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto login(MemberDto mdto);

	MemberDto idCheck(String id);

	MemberDto memberSearch(String name, String email);
	

}
