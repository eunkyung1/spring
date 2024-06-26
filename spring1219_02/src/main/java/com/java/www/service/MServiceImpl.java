package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MServiceImpl implements MService {
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public MemberDto loginCheck(MemberDto mdto) {
		MemberDto memberDto = memberMapper.loginCheck(mdto);
		return memberDto;
	}

}
